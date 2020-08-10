package less7;

import java.util.LinkedList;

public class BreadthFirstPath {

    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public BreadthFirstPath(MyGraph graph, int source) {
        this.source = source;

        marked = new boolean[graph.getVertexCount()];
        edgeTo = new int[graph.getVertexCount()];

        bfs(graph, source);
    }


    private void bfs(MyGraph graph, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(source);
        marked[source] = true;

        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            for (int w : graph.getAdjList(vertex)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = vertex;
                    queue.addLast(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public LinkedList<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;

        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = v;
        while (vertex != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }
}
