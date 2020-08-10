package less7;

import java.util.LinkedList;

public class MyGraph {
    private int vertexCount; // ввршины
    private int edgeCount;  //ребра
    private LinkedList<Integer>[] adjList;  // массив списков смежности

    public MyGraph(int vertexCount) {
        if (vertexCount < 0) {
            throw new IllegalArgumentException("vertexCount: " + vertexCount);
        }
        this.vertexCount = vertexCount;
        adjList = new LinkedList[vertexCount];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public LinkedList<Integer> getAdjList(int vertex) { // возврат клона листа для переданной вершины
        return (LinkedList<Integer>) adjList[vertex].clone();
    }

    public void addEdge(int v1, int v2) {
        if (v1 < 0 || v2 < 0 || v1 >= vertexCount || v2 >= vertexCount) {
            throw new IllegalArgumentException("v1: " + v1 + " | " + "v2: " + v2);
        }
        adjList[v1].add(v2);
        if (v1 == v2) return;
        adjList[v2].add(v1);
    }
}
