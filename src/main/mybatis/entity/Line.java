package entity;

public class Line {
	private int line_id;
	private String sight_name;
	private String line_lati;
	private String line_longi;
	
	public Line() {
	}

	public Line(int line_id, String sight_name, String line_lati, String line_longi) {
		super();
		this.line_id = line_id;
		this.sight_name = sight_name;
		this.line_lati = line_lati;
		this.line_longi = line_longi;
	}

	public int getLine_id() {
		return line_id;
	}

	public void setLine_id(int line_id) {
		this.line_id = line_id;
	}

	public String getSight_name() {
		return sight_name;
	}

	public void setSight_name(String sight_name) {
		this.sight_name = sight_name;
	}

	public String getLine_lati() {
		return line_lati;
	}

	public void setLine_lati(String line_lati) {
		this.line_lati = line_lati;
	}

	public String getLine_longi() {
		return line_longi;
	}

	public void setLine_longi(String line_longi) {
		this.line_longi = line_longi;
	}

	@Override
	public String toString() {
		return "Line [line_id=" + line_id + ", sight_name=" + sight_name + ", line_lati=" + line_lati + ", line_longi="
				+ line_longi + "]";
	}
}
