package dsa.strings;

public class Program92 {

	public static void main(String[] args) {
		System.out.println(smallestWindow("timetopractice", "toc"));
	}

	public static String smallestWindow(String s, String p) {
		int[] parray = new int[256];
		for (int i = 0; i < p.length(); i++) {
			parray[p.charAt(i)]++;
		}

		String res = "";
		int minLen = Integer.MAX_VALUE;
		int i = 0, j = 0, l = s.length();
		int[] sarr = new int[256];
		StringBuilder sb = new StringBuilder();
		while (i < l && j < l) {
			sarr[s.charAt(j)]++;
			sb.append(s.charAt(j));
			if (contains(sarr, parray)) {
				boolean flag = false;
				char c = 0;
				while (i < j && contains(sarr, parray)) {
					c = s.charAt(i);
					sarr[s.charAt(i)]--;
					sb.deleteCharAt(0);
					i++;
				}
				if (c != 0) {
					sarr[c]++;
					sb.insert(0, c);
				}

				if (minLen > sb.length()) {
					minLen = sb.length();
					res = sb.toString();
				}
			}
			j++;
		}
		return res;
	}

	private static boolean contains(int[] sarr, int[] parray) {
		boolean flag = false;
//		int[] temp = new int[256];
//		for (int i = 0; i < parray.length; i++) {
//			
//		}
		for (int i = 0; i < parray.length; i++) {
			if (parray[i] <= sarr[i]) {
				flag = true;
			} else {
				return false;
			}
		}
		return flag;
	}
}
