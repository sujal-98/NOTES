import java.util.*;

class Prims {

    // Prim's Algorithm is a greedy algorithm used to find the Minimum Spanning Tree
    // (MST) of a connected, weighted, and undirected graph. The MST is a subset of
    // the edges that connects all vertices in the graph without any cycles and with
    // the minimum possible total edge weight.

    // How Prim's Algorithm Works:

    // Initialize: Start with an arbitrary node (vertex) as part of the MST.
    // Initially, the MST contains only this node and no edges.
    // Grow the MST: Find the minimum-weight edge that connects a node in the MST to
    // a node outside the MST.
    // Add this edge and the connected node to the MST.
    // Repeat: Continue selecting the smallest edge connecting a vertex in the MST
    // to a vertex outside the MST until all vertices are included in the MST.

    // Steps of Prim's Algorithm:

    // Start with a vertex. Pick any vertex as the starting point (let's call it u).
    // Mark the vertex. Add u to the set of MST vertices.
    // Choose the minimum-weight edge. Among all edges connected to the vertices in
    // the MST, find the edge with the smallest weight that leads to a vertex not
    // yet in the MST.
    // Add the vertex. Add the new vertex connected by the selected edge to the MST.
    // Repeat. Repeat steps 3 and 4 until all vertices are included in the MST.

    // Data Structures Used:

    // Min-Heap (Priority Queue): To efficiently select the minimum-weight edge at
    // each step.
    // Array/HashMap for Weights: To store the minimum weights for each vertex (the
    // minimum weight to connect that vertex to the MST).
    // Visited Array: To track which vertices are already included in the MST.

    // Time Complexity:
    // Prim's algorithm can be implemented in various ways. The most efficient way
    // uses a priority queue (min-heap), which gives a time complexity of O(E log
    // V), where E is the number of edges and V is the number of vertices.


    static class Edge {
        int vertex;
        int weight;
        
        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
  

    public static int prim(List<List<Edge>> graph, int V) {

        boolean[] checked = new boolean[V];
        
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        
        queue.add(new Edge(0, 0));
        
        int minCost = 0;
        
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int u = edge.vertex;
            
            if (checked[u]) {
                continue;
            }
            
            checked[u] = true;
            minCost += edge.weight;
            
            for (Edge neighbor : graph.get(u)) {
                if (!checked[neighbor.vertex]) {
                    queue.add(new Edge(neighbor.vertex, neighbor.weight));
                }
            }
        }
        
        return minCost;
    }

    public static void main(String[] args) {
        int V = 4;
        
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        
        graph.get(0).add(new Edge(1, 1));
        graph.get(0).add(new Edge(2, 2));
        graph.get(1).add(new Edge(0, 1));
        graph.get(1).add(new Edge(2, 3));
        graph.get(1).add(new Edge(3, 3));
        graph.get(2).add(new Edge(0, 2));
        graph.get(2).add(new Edge(1, 3));
        graph.get(2).add(new Edge(3, 2));
        graph.get(3).add(new Edge(1, 3));
        graph.get(3).add(new Edge(2, 2));
        
        int minCost = prim(graph, V);
        System.out.println("Minimum Cost of MST: " + minCost);
    }
}