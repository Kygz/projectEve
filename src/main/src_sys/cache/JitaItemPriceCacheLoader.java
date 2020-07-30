package cache;

import com.google.common.cache.CacheLoader;
import org.apache.log4j.Logger;
import po.JitaItem;
import util.JitaUtil;

public class JitaItemPriceCacheLoader extends CacheLoader<String, JitaItem> {
    private static Logger log = Logger.getLogger(JitaItemPriceCacheLoader.class);

    @Override
    public JitaItem load(String itemId) throws Exception {
        log.info("itemPrice缓存木得，实查");
        return JitaUtil.getItemInfo(itemId);
    }
}
