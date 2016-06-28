package manager;

import po.ItemPo;
import po.JitaItem;

import java.util.List;

/**
 * 取JitaItem Manager
 */
public interface JitaManager {
    /**
     * 按id取出唯一结果
     *  * @param itemName
     * @return
     */
    public JitaItem queryJitaItemById(String id);

    /**
     * 按名称取出名称前五 无则返回""
     * 逻辑 有即有 无则模糊，唯一则有 没救返null
     * @param itemName
     * @return
     */
    public List<ItemPo> queryJitaItemNameListByName(String itemName);
}
