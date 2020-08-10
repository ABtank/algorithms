package less7;

/**
 * Обход в глубину
 * операция систематического посещения всех вершин
 * из заданной, которые связаны между собой ребрами.
 */
public class DepthFirstPaths extends Detour {

    public DepthFirstPaths(MyGraph graph, int source) {
        super(graph,source);
        dfs(graph, source);
    }

    private void dfs(MyGraph graph, int v) {
        getMarked()[v] = true;
        for (int w : graph.getAdjList(v)) {
            if (!getMarked()[w]) {
                getEdgeTo()[w] = v;
                dfs(graph, w);
            }
        }
    }

}
