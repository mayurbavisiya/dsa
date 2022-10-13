package dsa.strings;

public class Program90 {

	public static void main(String[] args) {
		System.out.println(findMinCharnNeedToAdd("AAABCDAA"));
		// AAABCDAA
	}

	public static int findMinCharnNeedToAdd(String a) {
		int i = 0, j = a.length() - 1;
		int count = 0, temp = 0;
		boolean flag = false;

		while (i <= j) {
			if (a.charAt(i) != a.charAt(j)) {
				if (i != j) {
					count++;
				}
				j--;
			} else {
				temp += 2;
				flag = true;
				i++;
				j--;
			}
		}
		return count;
	}
}
