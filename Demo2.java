package in.practice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Emp {
	private int id;
	private String name;
	private int age;
	private String loc;
	private String dept;
	private double sal;
	private LocalDate doj;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public Emp(int id, String name, int age, String loc, String dept, double sal, LocalDate doj) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.loc = loc;
		this.dept = dept;
		this.sal = sal;
		this.doj = doj;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", age=" + age + ", loc=" + loc + ", dept=" + dept + ", sal=" + sal
				+ ", doj=" + doj + "]";
	}
	public void getFeature1() {
		System.out.println();
	}
}

public class Demo2 {
	int num;
	String ss=null;
	public int getData() {
		try {
//			num = 10 / 0;
			System.out.println(ss.length());
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage()+" ");
		}
		finally {
			System.out.println(10/0);
		}
		return num;
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Demo2 d2=new Demo2();
		int data = d2.getData();
		System.out.println(data);
		
		List<Emp> list = Arrays.asList(new Emp(1, "A", 10, "Hyd", "Dev", 100.0, LocalDate.of(2006, 10, 10)),
				new Emp(3, "C", 15, "Hyd", "Dev", 600.0, LocalDate.of(2006, 10, 10)),
				new Emp(1, "S", 70, "Bang", "Test", 100.0, LocalDate.of(2016, 10, 10)),
				new Emp(1, "Z", 40, "Delhi", "Devops", 1000.0, LocalDate.of(2006, 10, 11)),
				new Emp(1, "F", 11, "Bang", "Test", 700.0, LocalDate.of(2006, 10, 10)),
				new Emp(1, "K", 30, "Bang", "Test", 100.0, LocalDate.of(2009, 10, 10)),
				new Emp(1, "P", 50, "Delhi", "Devops", 100.0, LocalDate.of(2006, 10, 10)),
				new Emp(5, "G", 19, "Hyd", "Dev", 900.0, LocalDate.of(2006, 9, 10)),
				new Emp(1, "L", 16, "Delhi", "Devops", 1300.0, LocalDate.of(2003, 10, 10)));

		Double sumSal = list.stream().collect(Collectors.summingDouble(Emp::getSal));
		System.out.println(sumSal);

		Map<String, List<Emp>> dept2 = list.stream().sorted(Comparator.comparing(Emp::getSal))
				.collect(Collectors.groupingBy(Emp::getDept));
		dept2.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

		Map<String, Long> dept1 = list.stream().collect(Collectors.groupingBy(Emp::getDept, Collectors.counting()));
		dept1.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

		Map<String, Double> dept = list.stream()
				.collect(Collectors.groupingBy(Emp::getDept, Collectors.summingDouble(Emp::getSal)));
		dept.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

		String str = "parthasaradhi";

		Map<Character, Long> occurence = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(i -> i, Collectors.counting()));
		occurence.entrySet().stream().filter(entry -> entry.getValue() > 1)
				.forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

		String str2 = "Java features and java methods";

		Optional<String> max = Arrays.asList(str2.split(" ")).stream().max(Comparator.comparingInt(String::length));
		System.out.println(max.get());

		List<Map<Character, Long>> list2 = Arrays.asList(str2.split(" ")).stream().map(
				s -> s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(i -> i, Collectors.counting())))
				.toList();

		list2.forEach(map -> map.forEach((key, value) -> System.out.println(key + " " + value)));

		Collections.sort(list, new Comparator<Emp>() {

			@Override
			public int compare(Emp o1, Emp o2) {
//				return Double.compare(o1.getSal(), o2.getSal());
				return o1.getName().compareTo(o2.getName());
			}
		});
		list.forEach(f -> System.out.println(f + " === "));

		Collections.sort(list, Comparator.comparing(Emp::getSal).thenComparing(Emp::getName));
		list.forEach(f -> System.out.println(f + " ===++++++++ "));

		int[] a1 = { 1, 2, 3, 4 };
		int[] a2 = { 5, 6, 7 };
		int[] a3 = new int[a1.length + a2.length];
		System.arraycopy(a1, 0, a3, 0, a1.length);
		System.arraycopy(a2, 0, a3, a1.length, a2.length);
		System.out.println(Arrays.toString(a3));

		Object[] array = Stream.concat(Arrays.stream(a1).boxed(), Arrays.stream(a2).boxed()).toArray();
		System.out.println(Arrays.toString(array));

		Object[] array2 = Stream.concat(Arrays.stream(array).filter(i -> (int) i % 2 == 0),
				Arrays.stream(array).filter(i -> (int) i % 2 != 0)).toArray();
		System.out.println(Arrays.toString(array2));
		
		int[] a12= {1,2,3,5,6,8,14};
		
		List<Integer> list3 = Arrays.stream(a12).boxed().toList();
		for(int i=1;i<=14;i++) {
			if(!list3.contains(i)) {
				System.out.println(i+" Missing number");
			}
		}
		
		for(int i=1;i<14;i++) {
			boolean found=false;
			
			for(int item:a12) {
				if(item==i) {
					found=true;
					break;
				}
			}
			if(!found) {
				System.out.println(i+" m");
			}
		}

	}

}
