Day 13
Java Code: 
 
 package Day12;

public class Trie {
	private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    // Checks if there is any word in the trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");

        System.out.println(trie.startsWith("app")); // Output: true
        System.out.println(trie.startsWith("appl")); // Output: true
        System.out.println(trie.startsWith("banana")); // Output: false
    }
}

package Day12;

public class TrieNode {
	 TrieNode[] children;
	    boolean isEndOfWord;

	    public TrieNode() {
	        children = new TrieNode[26];  // Assuming only lowercase English letters
	        isEndOfWord = false;
	    }
	}
