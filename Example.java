package in.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Example {
	public static void main(String[] args) {
//		System.out.println("=============" + args.length + "=========");
//		System.out.println("=======================");

		// Input: nums = [2,7,11,15], target = 9
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//		for(int i=0;i<arr.length;i++) {
//			System.out.println(i);
//			for(int j=0;j<arr.length;j++) {
//				if(j==2) {
//					return;
//				}
//			}
//		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) {
				for (int j = arr.length - 1; j > i; j--) {
					if (arr[j] % 2 == 0) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						break;
					}
				}
			}
		}

		System.out.println(Arrays.toString(arr));

		int target = 9;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int current = arr[i];
			int number = target - current;
			if (map.containsKey(current)) {
				System.out.println(map.get(current) + " " + i);
			}
			map.put(number, i);
		}
//
//		for (int i = 0; i < arr.length; i++) {
//			int j = i + 1;
//			while (j < arr.length) {
//				if (i != j && target == arr[i] + arr[j]) {
//					System.out.println(i + " " + j);
////					return;
//				}
//				j++;
//			}
//		}
//		System.out.println("=======================");

	}
}
