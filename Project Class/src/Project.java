
public class Project {
	private String name;
	private String description;
	
	public Project() {
		this.setName("Default");
		this.setDescription("Default");
	}
	
	public Project(String name) {
		this.setName(name);
		this.setDescription("Default");
	}
	
	public Project(String name, String description) {
		this.setName(name);
		this.setDescription(description);		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
