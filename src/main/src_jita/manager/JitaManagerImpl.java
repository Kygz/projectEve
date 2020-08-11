package manager;

import cache.BlueprintCacheLoader;
import cache.JitaItemCacheLoader;
import cache.JitaItemPriceCacheLoader;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;
import dao.JitaDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;
import po.BlueprintPo;
import po.ItemPo;
import po.JitaGroupPo;
import po.JitaItem;
import util.JitaUtil;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 取JitaItem Manager
 */
@Service
public class JitaManagerImpl implements JitaManager{
    private static Logger log = Logger.getLogger(JitaManagerImpl.class);

    @Autowired
    private JitaDao jitaDao;

    private LoadingCache<Long,ItemPo> jitaItemCacheMap;
    private LoadingCache<String,JitaItem> jitaItemPriceCacheMap;
    private LoadingCache<Long, BlueprintPo> blueprintCacheMap;

    @PostConstruct
    private void init(){
        jitaItemCacheMap = CacheBuilder.newBuilder()
                .maximumSize(2000)
                .initialCapacity(20)
                .build(new JitaItemCacheLoader());
        jitaItemPriceCacheMap = CacheBuilder.newBuilder()
                .maximumSize(2000)
                .initialCapacity(20)
                .expireAfterWrite(30, TimeUnit.MINUTES)
                .build(new JitaItemPriceCacheLoader());

        blueprintCacheMap = CacheBuilder.newBuilder()
                .maximumSize(5000)
                .initialCapacity(20)
                .build(new BlueprintCacheLoader());

        reloadBlueprintCache();
    }

    private void reloadBlueprintCache(){
        log.info("读取蓝图信息-start");
        long startTime = new Date().getTime();
        URL resource = this.getClass().getResource("data/sde/fsd/blueprints.yaml");
        if(resource != null && resource.getFile() != null){
            File blueprintFile = new File(resource.getFile());
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(blueprintFile);
                Object loadObj = yaml.load(fileInputStream);
                if(loadObj != null){
                    LinkedHashMap<Integer, LinkedHashMap> originObj = (LinkedHashMap<Integer, LinkedHashMap>) loadObj;
                    LinkedHashMap<Long, LinkedHashMap> mapObj = new LinkedHashMap<>();
                    originObj.keySet().forEach( integer -> {
                        mapObj.put(integer.longValue(), originObj.get(integer));
                    });
                    ImmutableMap<Long, ItemPo> allItem = jitaItemCacheMap.getAll(new ArrayList<>(mapObj.keySet()));
                    mapObj.keySet().forEach( id -> {
                        ItemPo itemPo = allItem.get(id);
                        if(itemPo != null){
                            BlueprintPo blueprintPo = new BlueprintPo(mapObj.get(id));
                            blueprintPo.setBlueprintTypeName(itemPo.getItem_name());
                            blueprintCacheMap.put(id,blueprintPo);
                        }
                    });
                }
            } catch (FileNotFoundException | ExecutionException e) {
                log.info("读取蓝图失败");
                e.printStackTrace();
            }
            long endTime = new Date().getTime();
            log.info("读取蓝图信息-end,耗时：" + (endTime - startTime)/1000 + "s");
        }
    }
    public JitaItem queryJitaItemPriceById(String id) {
        try {
            return jitaItemPriceCacheMap.get(id);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ItemPo queryJitaItemById(Long id) {
        try {
            return jitaItemCacheMap.get(id);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ItemPo> queryJitaItemNameListByName(String itemName){
        return jitaDao.queryJitaItemByName(itemName);
    }

    //-------------------------------
    public List<JitaGroupPo> queryJitaGroupsByUserId(Long userId){
        List result;
        result = jitaDao.queryJitaGroupsByUserId(userId);
        if(result == null){
            result = new ArrayList<>();
        }
        return result;
    }

    public void saveJitaGroup(JitaGroupPo jitaGroupPo){
        jitaDao.saveJitaGroup(jitaGroupPo);
    }

    @Override
    public void deleteJitaGroupBySectionIdAndUserId(Long sectionId, Long userId) {
        JitaGroupPo jitaGroupPo = jitaDao.queryJitaGroupsBySectionIdAndUserId(sectionId, userId);
        if(jitaGroupPo != null){
            jitaDao.deleteJitaGroupsBySectionIdAndUserId(sectionId,userId);
        }
    }

    @Override
    public HashMap<Long,BlueprintPo> getAllBlueprintMap(){
        return new HashMap<>(blueprintCacheMap.asMap());
    }
}
