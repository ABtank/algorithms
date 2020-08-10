package less7;

import java.util.LinkedList;

/**
 * Обход в глубину
 * операция систематического посещения всех вершин
 * из заданной, которые связаны между собой ребрами.
 */
public class DepthFirstPaths {

    private boolean[] marked; // массив посещений
    private int[] edgeTo;     // откуда пришли
    private int source;       // откуда начинаем обход

    public DepthFirstPaths(MyGraph graph, int source) {
        this.source = source;

        marked = new boolean[graph.getVertexCount()];
        edgeTo = new int[graph.getVertexCount()];

        dfs(graph, source);
    }

    private void dfs(MyGraph graph, int v) {
        marked[v] = true;
        for (int w : graph.getAdjList(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }
//    есть ли путь
    public boolean hasPathTo(int v) {
        return marked[v];
    }
//    какой путь
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
