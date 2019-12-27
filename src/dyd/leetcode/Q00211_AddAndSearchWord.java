package dyd.leetcode;

/**
 * 211. Add and Search Word - Data structure design -- Medium
 *
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 *
 * Example:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
public class Q00211_AddAndSearchWord {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isLeaf;
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Q00211_AddAndSearchWord() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        int i = 0;
        for (; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (node.children[pos] == null) {
                break;
            }
            node = node.children[pos];
        }

        for (; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            node.children[pos] = new TrieNode();
            if (i == word.length() - 1) {
                node.children[pos].isLeaf = true;
            }
            node = node.children[pos];
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(TrieNode node, String word, int start) {
        int i = start;
        for (; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (int j = 0; j < 26; j ++) {
                    if (node.children[j] != null && search(node.children[j], word, i + 1)) {
                        return true;
                    }
                }
                return false;
            }

            int pos = word.charAt(i) - 'a';
            if (node.children[pos] == null) {
                break;
            }

            node = node.children[pos];
        }

        return i == word.length() && node != null && node.isLeaf;
    }

    public static void main(String[] args) {
        test(new String[] {"bad", "dad", "map"}, new String[] {"pad", "bad", "m.p", "..d"});
        test(new String[] {"at", "and", "an", "add"}, new String[] {"a", ".at"});
    }

    private static void test(String[] dict, String[] words) {
        System.out.printf("Words: %s\n", Arrays.toString(dict));

        Q00211_AddAndSearchWord q = new Q00211_AddAndSearchWord();
        for (String word : dict) {
            q.addWord(word);
        }

        for (String word: words) {
            System.out.printf("search %s: %b\n", word, q.search(word));
        }
    }
}
