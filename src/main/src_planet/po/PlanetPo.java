package po;

import util.SysUtil;

import java.util.Date;
/**
 * 行星开发实体类
 * @author kygz
 *
 */
public class PlanetPo {
	private Long planet_id;
	private String planet_user_id;
	private String planet_user_name;
	private Date planet_update_date;
	private long planet_star1 = 0;
	private long planet_star2 = 0;
	private long planet_star3 = 0;
	private long planet_star4 = 0;
	private long planet_star5 = 0;
	private long planet_star6 = 0;
	private long planet_star7 = 0;
	private double planet_star1_price = 0;
	private double planet_star2_price = 0;
	private double planet_star3_price = 0;
	private double planet_star4_price = 0;
	private double planet_star5_price = 0;
	private double planet_star6_price = 0;
	private double planet_star7_price = 0;

	public Long getPlanet_id() {
		return planet_id;
	}
	public void setPlanet_id(Long planet_id) {
		this.planet_id = planet_id;
	}
	public String getPlanet_user_id() {
		return planet_user_id;
	}
	public void setPlanet_user_id(String planet_user_id) {
		this.planet_user_id = planet_user_id;
	}
	public String getPlanet_user_name() {
		return planet_user_name;
	}
	public void setPlanet_user_name(String planet_user_name) {
		this.planet_user_name = planet_user_name;
	}
	public Date getPlanet_update_date() {
		return planet_update_date;
	}
	public void setPlanet_update_date(Date planet_update_date) {
		this.planet_update_date = planet_update_date;
	}
	public long getPlanet_star1() {
		return planet_star1;
	}
	public void setPlanet_star1(long planet_star1) {
		this.planet_star1 = planet_star1;
	}
	public long getPlanet_star2() {
		return planet_star2;
	}
	public void setPlanet_star2(long planet_star2) {
		this.planet_star2 = planet_star2;
	}
	public long getPlanet_star3() {
		return planet_star3;
	}
	public void setPlanet_star3(long planet_star3) {
		this.planet_star3 = planet_star3;
	}
	public long getPlanet_star4() {
		return planet_star4;
	}
	public void setPlanet_star4(long planet_star4) {
		this.planet_star4 = planet_star4;
	}
	public long getPlanet_star5() {
		return planet_star5;
	}
	public void setPlanet_star5(long planet_star5) {
		this.planet_star5 = planet_star5;
	}
	public long getPlanet_star6() {
		return planet_star6;
	}
	public void setPlanet_star6(long planet_star6) {
		this.planet_star6 = planet_star6;
	}
	public long getPlanet_star7() {
		return planet_star7;
	}
	public void setPlanet_star7(long planet_star7) {
		this.planet_star7 = planet_star7;
	}
	public double getPlanet_star1_price() {
		return planet_star1_price;
	}
	public void setPlanet_star1_price(double planet_star1_price) {
		this.planet_star1_price = planet_star1_price;
	}
	public double getPlanet_star2_price() {
		return planet_star2_price;
	}
	public void setPlanet_star2_price(double planet_star2_price) {
		this.planet_star2_price = planet_star2_price;
	}
	public double getPlanet_star3_price() {
		return planet_star3_price;
	}
	public void setPlanet_star3_price(double planet_star3_price) {
		this.planet_star3_price = planet_star3_price;
	}
	public double getPlanet_star4_price() {
		return planet_star4_price;
	}
	public void setPlanet_star4_price(double planet_star4_price) {
		this.planet_star4_price = planet_star4_price;
	}
	public double getPlanet_star5_price() {
		return planet_star5_price;
	}
	public void setPlanet_star5_price(double planet_star5_price) {
		this.planet_star5_price = planet_star5_price;
	}
	public double getPlanet_star6_price() {
		return planet_star6_price;
	}
	public void setPlanet_star6_price(double planet_star6_price) {
		this.planet_star6_price = planet_star6_price;
	}
	public double getPlanet_star7_price() {
		return planet_star7_price;
	}
	public void setPlanet_star7_price(double planet_star7_price) {
		this.planet_star7_price = planet_star7_price;
	}

	public void setIdIfNew() {
			this.setPlanet_id(SysUtil.longUUID());
	}
}
