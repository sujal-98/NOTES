import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    // Comparator function used for sorting edges based on weight
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
};

class Subset {
    int parent, rank;
};

public class KruskalMST {
    int vertices, edges;    // Number of vertices and edges
    Edge[] edge;            // Array of edges

    // Constructor
    KruskalMST(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        edge = new Edge[edges];
        for (int i = 0; i < edges; i++) {
            edge[i] = new Edge();
        }
    }

    // Find set of an element i (uses path compression)
    int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    // Union of two sets (uses union by rank)
    void union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        } else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    // Function to construct the MST using Kruskal's algorithm
    void kruskalMST() {
        Edge[] result = new Edge[vertices]; // This will store the resultant MST
        int e = 0; // Count of edges in the MST
        int i = 0; // Index variable used for sorted edges
        for (i = 0; i < vertices; ++i) {
            result[i] = new Edge();
        }

        // Step 1: Sort all edges in non-decreasing order of their weight
        Arrays.sort(edge);

        // Create subsets for union-find
        Subset[] subsets = new Subset[vertices];
        for (i = 0; i < vertices; ++i) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        i = 0; // Index used to pick the next edge

        // Number of edges to be taken is equal to V-1
        while (e < vertices - 1) {
            // Step 2: Pick the smallest edge. Check if it forms a cycle
            Edge nextEdge = edge[i++];

            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            // If including this edge doesn't cause a cycle, include it in the result
            if (x != y) {
                result[e++] = nextEdge;
                union(subsets, x, y);
            }
        }

        // Print the constructed MST
        System.out.println("Following are the edges in the constructed MST");
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
        }
    }

    // Main function to test Kruskal's algorithm
    public static void main(String[] args) {
        int vertices = 4;  // Number of vertices in graph
        int edges = 5;     // Number of edges in graph
        KruskalMST graph = new KruskalMST(vertices, edges);

        // Add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // Add edge 0
