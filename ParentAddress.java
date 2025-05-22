package in.practice;

public class ParentAddress extends Parent {
	String loc;

	public ParentAddress(int id, String name,String loc) {
		super(id, name);
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "ParentAddress [loc=" + loc + ", id=" + id + ", name=" + name + "]";
	}

}
