
package dsa.strings;

public class LongestCommonPrefix {

	static final int alphaBetSize = 26;

	public class TrieNode {
		TrieNode[] children = new TrieNode[alphaBetSize];
		boolean isENdofword;

		public TrieNode() {
			isENdofword = false;
			for (int i = 0; i < children.length; i++) {
				children[i] = null;
			}
		}
	}

	TrieNode root;

	public void insert(String key) {
		TrieNode crawl = root;
		int index;
		for (int i = 0; i < key.length(); i++) {
			index = key.charAt(i) - 'a';
			if (crawl.children[index] == null)
				crawl.children[index] = new TrieNode();
			crawl = crawl.children[index];
		}
		crawl.isENdofword = true;
	}

	public static void main(String[] args) {
		String[] strs = { "flower", "flow", "flight" };
		System.out.println(longestCommonPrefix(strs));
	}

	public static String longestCommonPrefix(String[] strs) {
		// for (int i = 0; i < strs.length; i++) {
		// new LongestCommonPrefix().insert(strs[i]);
		// }

		if (strs.length == 0)
			return "";
		String prefex = strs[0];
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(prefex) != 0) {
				prefex = prefex.substring(0, prefex.length() - 1);
			}
		}
		return prefex;
	}
}
