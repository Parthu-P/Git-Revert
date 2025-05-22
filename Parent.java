package in.practice;

public class Parent{

	int id;
	String name;
	public Parent(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Parent [id=" + id + ", name=" + name + "]";
	}
	
	
}
