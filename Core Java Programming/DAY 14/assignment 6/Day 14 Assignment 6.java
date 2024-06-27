

package Day14;
import java.util.*;

public class Graph {
    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adjacencyList; // Adjacency List

    // Constructor
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Add edge to the graph
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source); // Since the graph is undirected
    }

    // DFS helper function
    private void DFSUtil(int vertex, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[vertex] = true;
        System.out.print(vertex + " ");

        // Recur for all the vertices adjacent to this vertex
        for (int adj : adjacencyList[vertex]) {
            if (!visited[adj]) {
                DFSUtil(adj, visited);
            }
        }
    }

    // DFS function
    public void DFS(int startVertex) {
        // Mark all the vertices as not visited (set as false by default)
        boolean[] visited = new boolean[vertices];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(startVertex, visited);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        System.out.println("Depth-First Search (starting from vertex 0):");
        graph.DFS(0);
    }
}