package entity;

public class Value {
	private int value_id;
	private String sight_name;
	private String value_lati;
	private String value_longi;
	private int value_type;
	private String value_description;
	private String value_content;
	
	public Value() {
	}

	public Value(int value_id, String sight_name, String value_lati, String value_longi, int value_type,
			String value_description, String value_content) {
		super();
		this.value_id = value_id;
		this.sight_name = sight_name;
		this.value_lati = value_lati;
		this.value_longi = value_longi;
		this.value_type = value_type;
		this.value_description = value_description;
		this.value_content = value_content;
	}

	@Override
	public String toString() {
		return "Value [value_id=" + value_id + ", sight_name=" + sight_name + ", value_lati=" + value_lati
				+ ", value_longi=" + value_longi + ", value_type=" + value_type + ", value_description="
				+ value_description + ", value_content=" + value_content + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public int getValue_id() {
		return value_id;
	}

	public void setValue_id(int value_id) {
		this.value_id = value_id;
	}

	public String getSight_name() {
		return sight_name;
	}

	public void setSight_name(String sight_name) {
		this.sight_name = sight_name;
	}

	public String getValue_lati() {
		return value_lati;
	}

	public void setValue_lati(String value_lati) {
		this.value_lati = value_lati;
	}

	public String getValue_longi() {
		return value_longi;
	}

	public void setValue_longi(String value_longi) {
		this.value_longi = value_longi;
	}

	public int getValue_type() {
		return value_type;
	}

	public void setValue_type(int value_type) {
		this.value_type = value_type;
	}

	public String getValue_description() {
		return value_description;
	}

	public void setValue_description(String value_description) {
		this.value_description = value_description;
	}

	public String getValue_content() {
		return value_content;
	}

	public void setValue_content(String value_content) {
		this.value_content = value_content;
	}
}
