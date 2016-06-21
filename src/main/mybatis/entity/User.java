package entity;

public class User {
	
    private String user_id;
    private String user_name;
    private String user_password;
    
    private String user_phone;
    private String user_portrait;
    private String user_background;
    
    public User(){}
    
    public User(String user_id, String user_name, String user_password, String user_phone, String user_portrait, String user_background) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_phone = user_phone;
        this.user_portrait = user_portrait;
        this.user_background=user_background;
    }
	
    public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_portrait() {
		return user_portrait;
	}

	public void setUser_portrait(String user_portrait) {
		this.user_portrait = user_portrait;
	}

	public String getUser_background() {
		return user_background;
	}

	public void setUser_background(String user_background) {
		this.user_background = user_background;
	}

	@Override
    public String toString() {
        return "User [id=" + user_id + ", name=" + user_name + "]";
    }
}
