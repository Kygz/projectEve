package manager;

import cache.JitaItemCacheLoader;
import cache.JitaItemPriceCacheLoader;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import dao.JitaDao;
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 取JitaItem Manager
 */
@Service
public class JitaManagerImpl implements JitaManager{
    @Autowired
    private JitaDao jitaDao;

    private LoadingCache<Long,ItemPo> jitaItemCacheMap;
    private LoadingCache<String,JitaItem> jitaItemPriceCacheMap;
    private LoadingCache<Long, BlueprintPo> blueprintCacheMap;

    @PostConstruct
    private void init(){
        jitaItemCacheMap = CacheBuilder.newBuilder()
                .maximumSize(200)
                .initialCapacity(20)
                .build(new JitaItemCacheLoader());
        jitaItemPriceCacheMap = CacheBuilder.newBuilder()
                .maximumSize(200)
                .initialCapacity(20)
                .expireAfterWrite(30, TimeUnit.MINUTES)
                .build(new JitaItemPriceCacheLoader());

        URL resource = this.getClass().getResource("data/sde/fsd/blueprints.yaml");
        if(resource != null && resource.getFile() != null){
            File blueprintFile = new File(resource.getFile());
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(blueprintFile);
                Object loadObj = yaml.load(fileInputStream);
                if(loadObj != null){
                    LinkedHashMap<Integer, LinkedHashMap> mapObj = (LinkedHashMap<Integer, LinkedHashMap>) loadObj;
                    mapObj.keySet().forEach( id -> {
                        BlueprintPo blueprintPo = new BlueprintPo(mapObj.get(id));
                        System.out.println("id:" + blueprintPo.getBlueprintTypeId());

                        JitaItem itemInfo = JitaUtil.getItemInfo(blueprintPo.getBlueprintTypeId().toString());
                        if(itemInfo == null){
                            System.out.println(mapObj.get(id));
                        }
                    });
                }
                System.out.println("success");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
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
}
