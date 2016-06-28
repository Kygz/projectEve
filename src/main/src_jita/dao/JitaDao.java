package dao;

import po.ItemPo;

import java.util.List;

/**
 * JitaDao
 */
public interface JitaDao {

    public List<ItemPo> queryJitaItemByName(String itemName);
}
