package entity;

public class History {
	private int history_id;
	private String user_id;
	private String history_content;
	
	public History() {
	}

	public History(int history_id, String user_id, String history_content) {
		super();
		this.history_id = history_id;
		this.user_id = user_id;
		this.history_content = history_content;
	}

	public int getHistory_id() {
		return history_id;
	}

	public void setHistory_id(int history_id) {
		this.history_id = history_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getHistory_content() {
		return history_content;
	}

	public void setHistory_content(String history_content) {
		this.history_content = history_content;
	}

	@Override
	public String toString() {
		return "HIstory [history_id=" + history_id + ", user_id=" + user_id + ", history_content=" + history_content
				+ "]";
	}
}
