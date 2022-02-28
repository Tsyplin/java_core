package task_2_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		int[] array = {1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4};
		List<Integer> intList = new ArrayList<>();
		for (int x : array) {
			if (x > 0 && x % 2 == 0) {
				intList.add(x);
			}
		}
		Collections.sort(intList);
		System.out.println(intList);
	}
}
