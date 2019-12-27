package dyd.leetcode;

/**
 * 208. Implement Trie (Prefix Tree) -- Medium
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class Q00208_ImplementTrie {
    static class Trie {
        class TrieNode {
            private static final int LENGTH = 26;

            private TrieNode[] children;
            private boolean isEnd;

            public TrieNode() {
                children = new TrieNode[LENGTH];
            }

            public boolean containsKey(char ch) {
                return children[ch - 'a'] != null;
            }

            public TrieNode get(char ch) {
                return children[ch - 'a'];
            }

            public void put(char ch, TrieNode node) {
                children[ch - 'a'] = node;
            }

            public boolean isEnd() {
                return isEnd;
            }

            public void setEnd(boolean isEnd) {
                this.isEnd = isEnd;
            }
        }

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = root;
            int i = 0;
            for (; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (!node.containsKey(word.charAt(i))) {
                    break;
                }

                node = node.get(ch);
            }

            for (; i < word.length(); i++) {
                TrieNode newNode = new TrieNode();
                node.put(word.charAt(i), newNode);
                node = newNode;
            }

            node.setEnd(true);
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (!node.containsKey(word.charAt(i))) {
                    return false;
                }

                TrieNode nextNode = node.get(ch);
                if (i == word.length() - 1 && nextNode.isEnd()) {
                    return true;
                }

                node = node.get(ch);
            }
            return false;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);

                if (!node.containsKey(prefix.charAt(i))) {
                    return false;
                }

                node = node.get(ch);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

