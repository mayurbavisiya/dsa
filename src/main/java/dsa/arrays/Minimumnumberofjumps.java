package dsa.arrays;

public class Minimumnumberofjumps {

	static int minJumps(int[] arr) {
		if (arr[0] == 0)
			return -1;
		int farthest = 0, current = 0, jumps = 0, toReach = arr.length - 1;
		boolean isReachedtoCurrent = false;
		for (int i = 0; i < arr.length; i++) {

			farthest = Math.max(i + arr[i], farthest);
			if (i == current) {
				current = farthest;
				jumps++;
				isReachedtoCurrent = true;
			} else if (farthest < arr.length && arr[farthest] == 0) {
				
			}
		}
		return jumps;
	}

	public static void main(String[] args) {
		int[] a = { 2, 1, 0, 3 };
		System.out.println(minJumps(a));
	}
}
