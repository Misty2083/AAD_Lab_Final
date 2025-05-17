package withOOP.dfs;

import java.util.LinkedList;

public class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;
    private int visitOrder;

    public Graph(int vertices) {
        this. vertices = vertices;
        this.adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            this.adjacencyList[i] = new LinkedList<>();
        }
        this.visitOrder = 0;
    }

    public void addEdge(int from, int to) {
        adjacencyList[from].add(to);
    }

    public void DFS(int start) {
        boolean[] visited = new boolean[vertices];
        visitOrder = 0;
        System.out.println("Depth-First Search (DFS) traversal starting from vertex " + start + ":");
        DFSUtil(start, visited);
    }

    private void DFSUtil(int current, boolean[] visited) {
        visited[current] = true;
        visitOrder++;
        System.out.println("Vertex " + current + ": VisitOrder " + visitOrder);

        for (int neighbor : adjacencyList[current]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }
}