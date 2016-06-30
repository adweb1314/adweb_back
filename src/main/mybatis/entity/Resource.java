package entity;

public class Resource {
	private String resource_id;
	private String sight_name;
	private int resource_type;
	
	public Resource() {
	}

	public Resource(String resource_id, String sight_name, int resource_type) {
		super();
		this.resource_id = resource_id;
		this.sight_name = sight_name;
		this.resource_type = resource_type;
	}

	@Override
	public String toString() {
		return "Resource [resource_id=" + resource_id + ", sight_name=" + sight_name + ", resource_type="
				+ resource_type + "]";
	}

	public String getResource_id() {
		return resource_id;
	}

	public void setResource_id(String resource_id) {
		this.resource_id = resource_id;
	}

	public String getSight_name() {
		return sight_name;
	}

	public void setSight_name(String sight_name) {
		this.sight_name = sight_name;
	}

	public int getResource_type() {
		return resource_type;
	}

	public void setResource_type(int resource_type) {
		this.resource_type = resource_type;
	}
}
