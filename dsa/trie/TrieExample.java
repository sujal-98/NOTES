import java.util.HashMap;
import java.util.Map;

class TrieNode {
    // Each TrieNode can have multiple children, one for each character.
    Map<Character, TrieNode> children;
    // To mark the end of a word
    boolean isEndOfWord;

    // Constructor
    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class Trie {
    private final TrieNode root;

    // Constructor: Initialize root node
    public Trie() {
        root = new TrieNode();
    }

    // Method to insert a word into the Trie
    public void insert(String word) {
        TrieNode currentNode = root;
        for (char ch : word.toCharArray()) {
            // If the character is not already present, add a new node
            currentNode.children.putIfAbsent(ch, new TrieNode());
            currentNode = currentNode.children.get(ch);
        }
        // Mark the end of the word
        currentNode.isEndOfWord = true;
    }

    // Method to search for a word in the Trie
    public boolean search(String word) {
        TrieNode currentNode = root;
        for (char ch : word.toCharArray()) {
            // If the character is not found, return false
            if (!currentNode.children.containsKey(ch)) {
                return false;
            }
            currentNode = currentNode.children.get(ch);
        }
        // Return true if currentNode is at the end of a word
        return currentNode.isEndOfWord;
    }

    // Method to check if a prefix exists in the Trie
    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
        for (char ch : prefix.toCharArray()) {
            // If the character is not found, return false
            if (!currentNode.children.containsKey(ch)) {
                return false;
            }
            currentNode = currentNode.children.get(ch);
        }
        return true;
    }
}

public class TrieExample {
    public static void main(String[] args) {
        Trie trie = new Trie();
        
        // Insert words into the Trie
        trie.insert("apple");
        trie.insert("app");
        
        // Search for words in the Trie
        System.out.println(trie.search("apple"));  // Output: true
        System.out.println(trie.search("app"));    // Output: true
        System.out.println(trie.search("appl"));   // Output: false
        
        // Check if a prefix exists in the Trie
        System.out.println(trie.startsWith("app"));  // Output: true
        System.out.println(trie.startsWith("apz"));  // Output: false
    }
}
