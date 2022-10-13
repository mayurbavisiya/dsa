package dsa.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Program366 {
	public static void main(String[] args) {
		String beginWord = "ymain", endWord = "oecij";
		List<String> wordList = Arrays.asList(new String[] {"ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain"});
		System.out.println(ladderLength(beginWord, endWord, wordList));
	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		HashSet<String> hs = new HashSet<>();
		for (int i = 0; i < wordList.size(); i++) {
			hs.add(wordList.get(i));
		}
		if (!hs.contains(endWord)) {
			return 0;
		}

		Queue<String> q = new LinkedList<String>();
		q.add(beginWord);
		int level = 1;
		while (!q.isEmpty()) {
			int n = q.size();
			for (int i = 0; i < n; i++) {
				String currWord = q.poll();
				char[] currWordArr = currWord.toCharArray();
				for (int j = 0; j < currWordArr.length; j++) {
					char originalChar = currWordArr[j];
					for (char k = 'a'; k <= 'z'; k++) {
						if (originalChar == k)
							continue;
						currWordArr[j] = k;
						String newWord = String.valueOf(currWordArr);
						if (newWord.equalsIgnoreCase(endWord))
							return level + 1;
						if (hs.contains(newWord)) {
							q.add(newWord);
							hs.remove(newWord);
						}
					}
					currWordArr[j] = originalChar;
				}
			}
			level++;
		}
		return 0;
	}
}
