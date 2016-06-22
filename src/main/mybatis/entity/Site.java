package entity;

public class Site {
	private String site_id;
	private String site_type;
	private String site_desp;
	private int fav;
	private int foot;
	private int wish;
	
	
	public Site() {
	}


	public String getSite_id() {
		return site_id;
	}


	public void setSite_id(String site_id) {
		this.site_id = site_id;
	}


	public String getSite_type() {
		return site_type;
	}


	public void setSite_type(String site_type) {
		this.site_type = site_type;
	}


	public String getSite_desp() {
		return site_desp;
	}


	public void setSite_desp(String site_desp) {
		this.site_desp = site_desp;
	}


	public int getFav() {
		return fav;
	}


	public void setFav(int fav) {
		this.fav = fav;
	}


	public int getFoot() {
		return foot;
	}


	public void setFoot(int foot) {
		this.foot = foot;
	}


	public int getWish() {
		return wish;
	}


	public void setWish(int wish) {
		this.wish = wish;
	}


	@Override
	public String toString() {
		return "Site [site_id=" + site_id + ", site_type=" + site_type + ", site_desp=" + site_desp + ", fav=" + fav
				+ ", foot=" + foot + ", wish=" + wish + "]";
	}
}
