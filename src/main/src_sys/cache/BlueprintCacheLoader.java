package cache;

import com.google.common.cache.CacheLoader;
import po.BlueprintPo;
import java.util.Map;

public class BlueprintCacheLoader extends CacheLoader<Long, BlueprintPo> {
    @Override
    public BlueprintPo load(Long id) throws Exception {
        return null;
    }

    @Override
    public Map<Long, BlueprintPo> loadAll(Iterable<? extends Long> ids) throws Exception {
        return null;
    }
}
