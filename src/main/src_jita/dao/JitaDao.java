package dao;

import po.ItemPo;
import po.JitaGroupPo;

import java.util.List;

/**
 * JitaDao
 */
public interface JitaDao {

    public ItemPo queryJitaItemById(Long itemId);
    public List<ItemPo> queryJitaItemByName(String itemName);

    public List<JitaGroupPo> queryJitaGroupsByUserId(Long userId);
    public void saveJitaGroup(JitaGroupPo jitaGroupPo);
}
