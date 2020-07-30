package manager;

import po.ItemPo;
import po.JitaGroupPo;
import po.JitaItem;

import java.util.List;
import java.util.Set;

/**
 * 取JitaItem Manager
 */
public interface JitaManager {
    /**
     * 按id取指定的jita物品的价格对象（有缓存）
     *  * @param itemName
     * @return
     */
    public JitaItem queryJitaItemPriceById(String id);

    /**
     * 按id取指定的jita物品（有缓存）
     * @param id
     * @return
     */
    public ItemPo queryJitaItemById(Long id);
    /**
     * 按名称取出名称前五 无则返回""
     * 逻辑 有即有 无则模糊，唯一则有 没救返null
     * @param itemName
     * @return
     */
    public List<ItemPo> queryJitaItemNameListByName(String itemName);

    /**
     * 取展板list
     * @param userId
     * @return
     */
    public List<JitaGroupPo> queryJitaGroupsByUserId(Long userId);

    /**
     * 保存jitaGroupPo
     * @param jitaGroupPo
     */
    public void saveJitaGroup(JitaGroupPo jitaGroupPo);
}
