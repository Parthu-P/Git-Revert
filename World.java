package in.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class World {

//	Input: n = 4
//	Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]

	List<String> list1 = new ArrayList<>();
	List<String> list2 = new ArrayList<>();
	List<List<String>> list = new ArrayList<>();

	String s = "";

	public List<List<String>> solveNQueens(int n) {

		for (int i = 1; i <= n; i++) {
			if (i == 2) {
				s = s.concat("Q");
			} else {
				s = s.concat(".");
			}
		}
		list1.add(s);
		s = "";
		for (int i = 1; i <= n; i++) {
			if (i == 4) {
				s = s.concat("Q");
			} else {
				s = s.concat(".");
			}
		}
		list1.add(s);
		s = "";
		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				s = s.concat("Q");
			} else {
				s = s.concat(".");
			}
		}
		list1.add(s);
		s = "";
		for (int i = 1; i <= n; i++) {
			if (i == 3) {
				s = s.concat("Q");
			} else {
				s = s.concat(".");
			}
		}
		list1.add(s);
		s = "";

		list.add(list1);
		list.add(list2);
		System.out.println(list);
		return list;
	}

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] arr = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int current = nums[i];
			int number = target - current;
			if (map.containsKey(number)) {
				Integer integer = map.get(number);
				arr[0] = map.get(number);
				arr[1] = i;
			}
			map.put(current, i);
		}
		return arr;
	}

	public static void main(String[] args) {
		World w = new World();
		w.solveNQueens(4);
		int[] a = { 2, 71, 11, 15, 7 };
		int[] twoSum = w.twoSum(a, 9);
		System.out.println(Arrays.toString(twoSum));

		List<Integer> li = new ArrayList<>();
		Object[] array = { 1, 2, 3, 4, new int[] { 5, 6, 7, 8 }, 10, 11 };
		for (Object element : array) {
			if (element instanceof int[]) {
				int[] a1 = (int[]) element;
				for (int ele : a1) {
					li.add(ele);
				}
			} else {
				li.add((Integer) element);
			}
		}
		System.out.println(li);
	}
}
//
//	@SuppressWarnings("null")
//	public static void main(String[] args) {
//		World s = new World();
//		List<List<String>> solveNQueens = s.solveNQueens(4);
//		System.out.println(solveNQueens);
//		int[] a= {2,7,11,15};
//		int[] twoSum = s.twoSum(a, 9);
//		System.out.println(Arrays.toString(twoSum));

//		Input: "12+34-5*6"
//	    Output: ["12", "34", "5", "6"]

//		String input = "12+34-5*6*";
//		String m="+-*";
//		List<String> l = new ArrayList<>();
//		String k="";
//		for (int i = 0; i <= input.length()-1; i++) {
//			String string = Character.toString(input.charAt(i));
//			if(!m.contains(string)) {
//				k=k+string;
//			}
//			else {
//				l.add(k);
//				k="";
//			}
//		}
//		l.add(k);
//		System.out.println(l);

//		char[] charArray = input.toCharArray();
//		System.out.println(Arrays.toString(charArray));

//		String i="3[a]2[b]4[sd]";
//		aaabbsdsdsdsd;
//		List<String> l1 = new ArrayList<>();
//		String digit = "";
//		for (int i= 0; i < charArray.length; i++) {
//			if (Character.isDigit(charArray[i])) {
//				digit=digit.concat(String.valueOf(charArray[i]));
//			}else {
//				l1.add(digit);
//				digit="";
//			}
//
//		}
//		l1.add(digit);
//		System.out.println(l1);
//
//	}
//}
