package entity;

public class Sight {
	private String sight_name;
	private String sight_description;
	private int sight_type_id;
	private double sight_lati;
	private double sight_longi;
	private int sight_zoom;
	
	public Sight() {
	}

	public Sight(String sight_name, String sight_description, int sight_type_id, double sight_lati, double sight_longi,
			int sight_zoom) {
		super();
		this.sight_name = sight_name;
		this.sight_description = sight_description;
		this.sight_type_id = sight_type_id;
		this.sight_lati = sight_lati;
		this.sight_longi = sight_longi;
		this.sight_zoom = sight_zoom;
	}

	public String getSight_name() {
		return sight_name;
	}

	public void setSight_name(String sight_name) {
		this.sight_name = sight_name;
	}

	public String getSight_description() {
		return sight_description;
	}

	public void setSight_description(String sight_description) {
		this.sight_description = sight_description;
	}

	public int getSight_type_id() {
		return sight_type_id;
	}

	public void setSight_type_id(int sight_type_id) {
		this.sight_type_id = sight_type_id;
	}

	public double getSight_lati() {
		return sight_lati;
	}

	public void setSight_lati(double sight_lati) {
		this.sight_lati = sight_lati;
	}

	public double getSight_longi() {
		return sight_longi;
	}

	public void setSight_longi(double sight_longi) {
		this.sight_longi = sight_longi;
	}

	public int getSight_zoom() {
		return sight_zoom;
	}

	public void setSight_zoom(int sight_zoom) {
		this.sight_zoom = sight_zoom;
	}

	@Override
	public String toString() {
		return "Sight [sight_name=" + sight_name + ", sight_description=" + sight_description + ", sight_type_id="
				+ sight_type_id + ", sight_lati=" + sight_lati + ", sight_longi=" + sight_longi + ", sight_zoom="
				+ sight_zoom + "]";
	}
}
