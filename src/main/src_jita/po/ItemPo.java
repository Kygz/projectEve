package po;

/**
 * 对应item表中实体
 */
public class ItemPo {
    private Long item_id;
    private String item_name;
    private String item_desc;
    private String item_sell;
    private String item_order;

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_desc() {
        return item_desc;
    }

    public void setItem_desc(String item_desc) {
        this.item_desc = item_desc;
    }

    public String getItem_sell() {
        return item_sell;
    }

    public void setItem_sell(String item_sell) {
        this.item_sell = item_sell;
    }

    public String getItem_order() {
        return item_order;
    }

    public void setItem_order(String item_order) {
        this.item_order = item_order;
    }
}
