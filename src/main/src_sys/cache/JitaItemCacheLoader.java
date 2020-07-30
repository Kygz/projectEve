package cache;

import appContextUtil.AppContextUtil;
import com.google.common.cache.CacheLoader;
import dao.JitaDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import po.ItemPo;


public class JitaItemCacheLoader extends CacheLoader<Long, ItemPo> {
    private static Logger log = Logger.getLogger(JitaItemCacheLoader.class);

    @Autowired
    private JitaDao jitaDao;

    @Override
    public ItemPo load(Long itemId) throws Exception {
        log.info("item缓存木得，实查");
        return getJitaDao().queryJitaItemById(itemId);
    }

    public JitaDao getJitaDao() {
        if(jitaDao == null){
            jitaDao = AppContextUtil.getBean(JitaDao.class);
        }
        return jitaDao;
    }
}
