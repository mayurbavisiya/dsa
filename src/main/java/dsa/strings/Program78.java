package dsa.strings;

public class Program78 {

	public static void main(String[] args) {
		String[][] a = { { "D", "D", "D", "G", "D", "D" }, { "B", "B", "D", "E", "B", "S" },
				{ "B", "S", "K", "E", "B", "K" }, { "D", "D", "D", "D", "D", "E" }, { "D", "D", "D", "D", "D", "E" },
				{ "D", "D", "D", "D", "D", "G" } };

		String b = "GEEKS";
		int count = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j].charAt(0) == b.charAt(0)) {
					count += search(i, j, a, b, 0);
				}
			}
		}

		System.out.println(count);
	}

	private static int search(int row, int col, String[][] a, String target, int k) {
		int found = 0;
		if (row >= 0 && col >= 0 && row < a.length && col < a[0].length && k < target.length()
				&& a[row][col].charAt(0) == target.charAt(k)) {
			k++;
			String s = a[row][col];
			a[row][col] = "0";
			if (k == target.length())
				found = 1;
			else {
				found += search(row - 1, col, a, target, k);
				found += search(row + 1, col, a, target, k);
				found += search(row, col - 1, a, target, k);
				found += search(row, col + 1, a, target, k);
			}
			a[row][col] = s;

		}
		return found;
	}

	private static boolean contains(String[][] a, int i, int j, String b) {
		int len = b.length();
		for (int k = i; k < a.length; k++) {
			for (int k2 = j; k2 < a.length; k2++) {

			}
		}

		return false;
	}
}
