package in.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class sample {
	public static void main(String[] args) {
//		employeeList.streem().map(e- > e.salary).sort().skip(1).findFirst();
//		employeeList.streem().map(e- > e.salary).sort(Comparator.reverseOrder()).skip(1).findFirst();
		
		String s="andrapradesh";
		String v="aeiou";
		for(int i=0; i<s.length();i++) {
			if(!v.contains(Character.toString(s.charAt(i)))){
				System.out.print(s.charAt(i));
			}
		}
		String collect = s.chars().mapToObj(i->(char)i)
		.filter(i->!"aeiou".contains(i.toString())).map(i->i.toString()).collect(Collectors.joining());
		System.out.println(collect);
		
		s.chars().forEach(i -> {
		    char c = (char) i;
		    if (!v.contains(Character.toString(c))) {
		        System.out.print(c);
		        }
		});
		int[] arr= {1,1,2,2,3,3,4,3,2,4,5};
		
		int j=arr.length-1;
		for(int i=0;i<arr.length/2;i++) {
			if(i==j) {
				break;
			}else {
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				j--;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
