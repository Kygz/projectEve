package po;

import util.SysUtil;

import java.util.Date;

public class ShipAssemblyPo {
    private long shipAssembly_id;
    private long shipAssembly_creator_id;
    private String shipAssembly_creator_name;
    private Date shipAssembly_create_time;
    private String shipAssembly_title;
    private String shipAssembly_img;
    private String shipAssembly_content;
    private String shipAssembly_tag;
    private int shipAssembly_scope;
    private int shipAssembly_use_type;
    private int shipAssembly_ship_type;
    private int shipAssembly_ship_id;
    private String shipAssembly_equipment;

    public long getShipAssembly_id() {
        return shipAssembly_id;
    }

    public void setShipAssembly_id(long shipAssembly_id) {
        this.shipAssembly_id = shipAssembly_id;
    }

    public long getShipAssembly_creator_id() {
        return shipAssembly_creator_id;
    }

    public void setShipAssembly_creator_id(long shipAssembly_creator_id) {
        this.shipAssembly_creator_id = shipAssembly_creator_id;
    }

    public String getShipAssembly_creator_name() {
        return shipAssembly_creator_name;
    }

    public void setShipAssembly_creator_name(String shipAssembly_creator_name) {
        this.shipAssembly_creator_name = shipAssembly_creator_name;
    }

    public Date getShipAssembly_create_time() {
        return shipAssembly_create_time;
    }

    public void setShipAssembly_create_time(Date shipAssembly_create_time) {
        this.shipAssembly_create_time = shipAssembly_create_time;
    }

    public String getShipAssembly_title() {
        return shipAssembly_title;
    }

    public void setShipAssembly_title(String shipAssembly_title) {
        this.shipAssembly_title = shipAssembly_title;
    }

    public String getShipAssembly_img() {
        return shipAssembly_img;
    }

    public void setShipAssembly_img(String shipAssembly_img) {
        this.shipAssembly_img = shipAssembly_img;
    }

    public String getShipAssembly_content() {
        return shipAssembly_content;
    }

    public void setShipAssembly_content(String shipAssembly_content) {
        this.shipAssembly_content = shipAssembly_content;
    }

    public String getShipAssembly_tag() {
        return shipAssembly_tag;
    }

    public void setShipAssembly_tag(String shipAssembly_tag) {
        this.shipAssembly_tag = shipAssembly_tag;
    }

    public int getShipAssembly_scope() {
        return shipAssembly_scope;
    }

    public void setShipAssembly_scope(int shipAssembly_scope) {
        this.shipAssembly_scope = shipAssembly_scope;
    }

    public int getShipAssembly_use_type() {
        return shipAssembly_use_type;
    }

    public void setShipAssembly_use_type(int shipAssembly_use_type) {
        this.shipAssembly_use_type = shipAssembly_use_type;
    }

    public int getShipAssembly_ship_type() {
        return shipAssembly_ship_type;
    }

    public void setShipAssembly_ship_type(int shipAssembly_ship_type) {
        this.shipAssembly_ship_type = shipAssembly_ship_type;
    }
    public void setIdIfNew(){
        this.setShipAssembly_id(SysUtil.longUUID());
    }

    public String getShipAssembly_equipment() {
        return shipAssembly_equipment;
    }

    public void setShipAssembly_equipment(String shipAssembly_equipment) {
        this.shipAssembly_equipment = shipAssembly_equipment;
    }

    public int getShipAssembly_ship_id() {
        return shipAssembly_ship_id;
    }

    public void setShipAssembly_ship_id(int shipAssembly_ship_id) {
        this.shipAssembly_ship_id = shipAssembly_ship_id;
    }
}
