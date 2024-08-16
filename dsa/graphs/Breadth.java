// levels in a graph - distance from the starting node uss basis ke classify kr
// skty ho
// uses queue data structre
// needs visited array, mark starting node as true
// create an adjency list for the graph
// visit the neighbours of a element in the same level and visit them first
import java.util.*;


public class Breadth{
    public ArrayList<Integer> bfs(int n,ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> a=new ArrayList<>();
        int[] visited=new int[n];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        visited[0]=1;
        while(!q.isEmpty()){
            Integer val=q.poll();
            a.add(val);
            for(Integer i:adj.get(val)){
                if(visited[i]!=1){
                    visited[i]=1;
                    q.add(i);
                }
            }
        }
        return a;
    }
    public static void main(String[] args) {
        int n = 9;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(1).add(4);
        adj.get(2).add(4);
        adj.get(3).add(4);
        adj.get(4).add(1);  
        adj.get(4).add(2);
        adj.get(4).add(3);

        Breadth breadth = new Breadth();

        // Perform BFS starting from node 0
        ArrayList<Integer> result = breadth.bfs(n, adj);

        // Print the BFS traversal
        System.out.println("BFS Traversal: " + result);
    }
}

//space complexity
//-- a queue , visited node, adj 
// O(3N)-> O(N)

//time complexity
//-- O(N) + O(2*E) {2*E is total degrees}