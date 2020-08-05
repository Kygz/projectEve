package cache;

import appContextUtil.AppContextUtil;
import com.google.common.cache.CacheLoader;
import dao.JitaDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import po.ItemPo;
import util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JitaItemCacheLoader extends CacheLoader<Long, ItemPo> {
    private static Logger log = Logger.getLogger(JitaItemCacheLoader.class);

    @Autowired
    private JitaDao jitaDao;

    @Override
    public ItemPo load(Long itemId) throws Exception {
        log.info("item缓存木得，实查");
        return getJitaDao().queryJitaItemById(itemId);
    }

    @Override
    public Map<Long, ItemPo> loadAll(Iterable<? extends Long> keys) throws Exception {
        Map<Long, ItemPo> result = new HashMap<>();
        ArrayList<Long> ids = new ArrayList<>();
               for (Long key : keys) {
            ids.add(key);
        }
        List<ItemPo> itemPos = getJitaDao().queryJitaItemListByIds(ids);
        for (ItemPo itemPo : itemPos) {
            result.put(itemPo.getItem_id(),itemPo);
        }
        return result;
    }

    public JitaDao getJitaDao() {
        if(jitaDao == null){
            jitaDao = AppContextUtil.getBean(JitaDao.class);
        }
        return jitaDao;
    }
}
