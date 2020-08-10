package less7;

import java.util.LinkedList;

public abstract class Detour {

    private boolean[] marked; // массив посещений
    private int[] edgeTo;     // откуда пришли
    private int source;       // откуда начинаем обход

    public boolean[] getMarked() {
        return marked;
    }

    public void setMarked(boolean[] marked) {
        this.marked = marked;
    }

    public int[] getEdgeTo() {
        return edgeTo;
    }

    public void setEdgeTo(int[] edgeTo) {
        this.edgeTo = edgeTo;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public Detour(MyGraph graph, int source) {
        this.source = source;
        this.marked = new boolean[graph.getVertexCount()];
        this.edgeTo = new int[graph.getVertexCount()];
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
