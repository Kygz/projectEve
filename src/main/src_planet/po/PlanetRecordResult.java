package po;


public class PlanetRecordResult {
	private String planet_user_id;
	private String planet_user_name;
	private long planet_star1;
	private long planet_star2;
	private long planet_star3;
	private long planet_star4;
	private long planet_star5;
	private long planet_star6;
	private long planet_star7;
	
	
	public PlanetRecordResult(String planet_user_id,String planet_user_name) {
		super();
		this.planet_user_id = planet_user_id;
		this.planet_user_name = planet_user_name;
		this.planet_star1 = 0L;
		this.planet_star2 = 0L;
		this.planet_star3 = 0L;
		this.planet_star4 = 0L;
		this.planet_star5 = 0L;
		this.planet_star6 = 0L;
		this.planet_star7 = 0L;
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
	
	
}
