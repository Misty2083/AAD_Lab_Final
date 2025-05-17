package withOOP.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            this.adjacencyList[i] = new LinkedList<>();
        }
    }
    
    public void addEdge(int from, int to) {
        adjacencyList[from].add(to);
    }
    
    public void BFS(int start) {
        boolean[] visited = new boolean[vertices];
        int[] level = new int[vertices]; 
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        level[start] = 0;
        queue.add(start);

        System.out.println("Breadth-First Search (BFS) traversal starting from vertex " + start + ":");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println("Vertex " + current + ": Level " + level[current]);

            for (int neighbor : adjacencyList[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    level[neighbor] = level[current] + 1;
                    queue.add(neighbor);
                }
            }
        }
    }
}