package entity;

public class SightType {
	private int sight_type_id;
	private String sight_type_name;
	
	public SightType() {
	}

	public SightType(int sight_type_id, String sight_type_name) {
		super();
		this.sight_type_id = sight_type_id;
		this.sight_type_name = sight_type_name;
	}

	public int getSight_type_id() {
		return sight_type_id;
	}

	public void setSight_type_id(int sight_type_id) {
		this.sight_type_id = sight_type_id;
	}

	public String getSight_type_name() {
		return sight_type_name;
	}

	public void setSight_type_name(String sight_type_name) {
		this.sight_type_name = sight_type_name;
	}

	@Override
	public String toString() {
		return "SightType [sight_type_id=" + sight_type_id + ", sight_type_name=" + sight_type_name + "]";
	}
}
