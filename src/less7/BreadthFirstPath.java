package less7;

import java.util.LinkedList;

public class BreadthFirstPath extends Detour{

    public BreadthFirstPath(MyGraph graph, int source) {
        super(graph,source);
        bfs(graph, source);
    }


    private void bfs(MyGraph graph, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(source);
        getMarked()[source] = true;

        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            for (int w : graph.getAdjList(vertex)) {
                if (!getMarked()[w]) {
                    getMarked()[w] = true;
                    getEdgeTo()[w] = vertex;
                    queue.addLast(w);
                }
            }
        }
    }
}
