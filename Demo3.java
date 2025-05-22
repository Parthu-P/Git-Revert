package in.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo3 {
	Integer factor = 1;
	String str1 = null;

	public int getFactor(int a) {
		if (a == 0) {
			return factor;
		}
		factor *= a;
		getFactor(a - 1);
		return factor;
	}

	public String getReverse(String str) {
		if (str.length() <= 1) {
			return str;
		}
		return str.charAt(str.length() - 1) + getReverse(str.substring(0, str.length() - 1));
	}

	public static void main(String[] args) {
		Demo3 d = new Demo3();
		Integer factor2 = d.getFactor(5);
		System.out.println(factor2);
		String reverse = d.getReverse("Parthu1233");

		char[] ch = reverse.toCharArray();
		for (int i = ch.length - 1; i >= 0; i--) {
			System.out.print(ch[i]);
		}
		System.out.println();
		System.out.println(reverse.replace('P', 'G'));
		System.out.println(reverse.replaceAll("\\d+", "Parth"));

		int[] arr = { 1, 2, 3, 2, 3, 4, 3, 4 };

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		String s1 = "Parth";
		String s2 = "Paras";

		s1 = s1 + s2;
		s2 = s1.substring(0, s1.length() - s2.length());
		s1 = s1.substring(s2.length());
		System.out.println(s1 + " " + s2);

		String s = "parthasaradhi";
		Map<Character, Long> collect = s.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));
		collect.entrySet().stream().filter(i -> i.getValue() >= 2)
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEach(i -> System.out.println(i.getKey() + " " + i.getValue()));
		
		int[] ar= {1,1,1,2,2,2,3,3,3,4,4,44,3,3,2,1,9};
		

	}
}