package manager;

import cache.JitaItemCacheLoader;
import cache.JitaItemPriceCacheLoader;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import dao.JitaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.ItemPo;
import po.JitaGroupPo;
import po.JitaItem;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
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
