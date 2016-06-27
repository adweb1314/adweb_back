package entity;

public class Share {
	private int share_id;
	private String user_id;
	private String sight_name;
	private String to_user_id;
	
	public Share() {
	}

	public Share(int share_id, String user_id, String sight_name, String to_user_id) {
		super();
		this.share_id = share_id;
		this.user_id = user_id;
		this.sight_name = sight_name;
		this.to_user_id = to_user_id;
	}

	public int getShare_id() {
		return share_id;
	}

	public void setShare_id(int share_id) {
		this.share_id = share_id;
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

	public String getTo_user_id() {
		return to_user_id;
	}

	public void setTo_user_id(String to_user_id) {
		this.to_user_id = to_user_id;
	}

	@Override
	public String toString() {
		return "Share [share_id=" + share_id + ", user_id=" + user_id + ", sight_name=" + sight_name + ", to_user_id="
				+ to_user_id + "]";
	}
}
