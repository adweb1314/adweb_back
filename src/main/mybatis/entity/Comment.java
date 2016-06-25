package entity;

public class Comment {
	private int comment_id;
	private String user_id;
	private String sight_name;
	private int grade;
	private String comment;
	
	public Comment() {
	}

	public Comment(int comment_id, String user_id, String sight_name, int grade, String comment) {
		super();
		this.comment_id = comment_id;
		this.user_id = user_id;
		this.sight_name = sight_name;
		this.grade = grade;
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", user_id=" + user_id + ", sight_name=" + sight_name + ", grade="
				+ grade + ", comment=" + comment + "]";
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
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

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
