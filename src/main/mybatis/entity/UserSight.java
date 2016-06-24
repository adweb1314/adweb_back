package entity;

public class UserSight {
	private String user_id;
	private String sight_name;
	
	public UserSight() {
	}

	public UserSight(String user_id, String sight_name) {
		super();
		this.user_id = user_id;
		this.sight_name = sight_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getSight_name() {
		return sight_name;
	}

	public void setSight_name(String sight_name) {
		this.sight_name = sight_name;
	}

	@Override
	public String toString() {
		return "UserSight [user_id=" + user_id + ", sight_name=" + sight_name + "]";
	}
}
