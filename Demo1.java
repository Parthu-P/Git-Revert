package in.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Demo1 {

	public static Demo1 d=null;
	public static void main(String[] args) {
		List<String> words=Arrays.asList("java","atream","lambda","programming","api");
		Map<String, Long> map=new HashMap<>();
		int count=0;
		int index=0;
		for(int i=0;i<words.size();i++) {
			char[] charArray = words.get(i).toCharArray();
			int c=charArray.length;
			if(count<c) {
				count=c;
				index=i;
			}
		}
		System.out.println(words.get(index));
		
		words.stream().forEach(j->{
			Long collect = j.chars().mapToObj(k->(char)k).collect(Collectors.counting());
			map.put(j, collect);
		});
//		map.entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(i->{
//			System.out.println(i.getKey());
//		});
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(i->System.out.println(i.getKey()+" "+i.getValue()));
		
//		map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)
//				.thenComparing(Map.Entry::getValue)).forEach();
		
		Demo1 d1=new Demo1();
		Demo1 d2=new Demo1();
		
		Demo1 instance = d1.getInstance();
		System.out.println(instance.hashCode());
		
		Demo1 instance2 = d2.getInstance();
		System.out.println(instance2.hashCode());
		
		Optional<String> max = words.stream().max(Comparator.comparingInt(String::length));
		System.out.println(max.get());
		
	}
	public Demo1 getInstance() {
		if(d==null){
			d=new Demo1();
		}
		return d;
	}
				
}
