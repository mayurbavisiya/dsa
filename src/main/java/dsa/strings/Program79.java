package dsa.strings;

import java.util.ArrayList;

public class Program79 {

	public static int[][] searchWord(char[][] grid, String word) {
		ArrayList<int[]> ls = new ArrayList<int[]>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == word.charAt(0)) {
					if (search(i, j, grid, word, 0)) {
						ls.add(new int[] { i, j });
					}
				}
			}
		}
		System.out.println(ls);
		int[][] op = new int[ls.size()][2];
		return op;
	}

	// private static boolean search(int i, int j, int initI, int initj,
	// char[][] grid, String word, int k,
	// ArrayList<int[]> ls) {
	// boolean isFound = false;
	// if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && k <
	// word.length()
	// && grid[i][j] == word.charAt(k)) {
	// char c = grid[i][j];
	// grid[i][j] = '0';
	// k++;
	// if (k == word.length()) {
	// ls.add(new int[] { initI, initj });
	// isFound = true;
	// }
	// if (search(i + 1, j, initI, initj, grid, word, k, ls)) {
	// isFound = true;
	// } else if (search(i - 1, j, initI, initj, grid, word, k, ls)) {
	// isFound = true;
	// } else if (search(i + 1, j, initI, initj, grid, word, k, ls)) {
	// isFound = true;
	// } else if (search(i, j + 1, initI, initj, grid, word, k, ls)) {
	// isFound = true;
	// } else if (search(i + 1, j - 1, initI, initj, grid, word, k, ls)) {
	// isFound = true;
	// } else if (search(i - 1, j + 1, initI, initj, grid, word, k, ls)) {
	// isFound = true;
	// } else if (search(i - 1, j - 1, initI, initj, grid, word, k, ls)) {
	// isFound = true;
	// } else if (search(i + 1, j + 1, initI, initj, grid, word, k, ls)) {
	// isFound = true;
	// }
	//
	// grid[i][j] = c;
	// }
	// return isFound;
	// }

	private static boolean search(int i, int j, char[][] grid, String word, int k) {
		if (searchUtil(i, j, grid, word, k, "0")) {
			return true;
		}
		if (searchUtil(i, j, grid, word, k, "1")) {
			return true;
		}
		if (searchUtil(i, j, grid, word, k, "2")) {
			return true;
		}
		if (searchUtil(i, j, grid, word, k, "3")) {
			return true;
		}
		if (searchUtil(i, j, grid, word, k, "4")) {
			return true;
		}
		if (searchUtil(i, j, grid, word, k, "5")) {
			return true;
		}
		if (searchUtil(i, j, grid, word, k, "6")) {
			return true;
		}
		if (searchUtil(i, j, grid, word, k, "7")) {
			return true;
		}

		return false;
	}

	private static boolean searchUtil(int i, int j, char[][] grid, String word, int k, String dir) {
		if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && k < word.length()
				&& grid[i][j] == word.charAt(k)) {
			k++;
			if (k == word.length() ) {
				return true;
			}
			if (dir.equals("0")) {
				return  searchUtil(i - 1, j, grid, word, k, "0");
			}
			if (dir.equals("1")) {
				return searchUtil(i + 1, j, grid, word, k, "1");
			}
			if (dir.equals("2")) {
				return searchUtil(i, j - 1, grid, word, k, "2");
			}
			if (dir.equals("3")) {
				return searchUtil(i, j + 1, grid, word, k, "3");
			}
			if (dir.equals("4")) {
				return searchUtil(i - 1, j + 1, grid, word, k, "4");
			}
			if (dir.equals("5")) {
				return searchUtil(i + 1, j - 1, grid, word, k, "5");
			}
			if (dir.equals("6")) {
				return searchUtil(i + 1, j + 1, grid, word, k, "6");
			}
			if (dir.equals("7")) {
				return searchUtil(i - 1, j - 1, grid, word, k, "7");
			}
		}

		return false;
	}

	public static void main(String[] args) {
		char[][] grid = { {'c'}, {'a'}, {'b'} };
		String word = "abe";
		searchWord(grid, word);
	}
}
