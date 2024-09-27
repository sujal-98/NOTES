import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

// Node class to store character, frequency, left and right child
class HuffmanNode {
    char ch;
    int frequency;
    HuffmanNode left, right;

    HuffmanNode(char ch, int frequency) {
        this.ch = ch;
        this.frequency = frequency;
    }

    HuffmanNode(int frequency, HuffmanNode left, HuffmanNode right) {
        this.ch = '\0'; // Internal nodes do not represent any character
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }
}

// Comparator for the priority queue (min-heap)
class HuffmanComparator implements java.util.Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.frequency - y.frequency;
    }
}

public class HuffmanCoding {

    // Generates the Huffman tree
    public static HuffmanNode buildHuffmanTree(Map<Character, Integer> frequencyMap) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(new HuffmanComparator());

        // Create leaf nodes for each character and add to the priority queue
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        // Build the Huffman Tree
        while (pq.size() > 1) {
            // Remove the two nodes with the lowest frequency
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();

            // Create a new internal node with these two nodes as children
            HuffmanNode newNode = new HuffmanNode(left.frequency + right.frequency, left, right);
            pq.add(newNode);
        }

        // The remaining node is the root of the Huffman Tree
        return pq.poll();
    }

    // Generate the codes based on the tree
    public static void generateHuffmanCodes(HuffmanNode root, String code, Map<Character, String> huffmanCodeMap) {
        if (root == null) {
            return;
        }

        // If it's a leaf node, store the character and its code
        if (root.left == null && root.right == null) {
            huffmanCodeMap.put(root.ch, code);
        }

        // Traverse left and right
        generateHuffmanCodes(root.left, code + "0", huffmanCodeMap);
        generateHuffmanCodes(root.right, code + "1", huffmanCodeMap);
    }

    // Main function to build the Huffman tree and generate codes
    public static void huffmanEncode(String text) {
        // Frequency Map for storing frequency of characters
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : text.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Build the Huffman Tree
        HuffmanNode root = buildHuffmanTree(frequencyMap);

        // Generate Huffman codes
        Map<Character, String> huffmanCodeMap = new HashMap<>();
        generateHuffmanCodes(root, "", huffmanCodeMap);

        // Print the Huffman codes
        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : huffmanCodeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Encode the input text using Huffman codes
        System.out.println("\nEncoded Text:");
        StringBuilder encodedText = new StringBuilder();
        for (char ch : text.toCharArray()) {
            encodedText.append(huffmanCodeMap.get(ch));
        }
        System.out.println(encodedText.toString());
    }

    public static void main(String[] args) {
        String text = "huffman coding algorithm example";
        huffmanEncode(text);
    }
}
