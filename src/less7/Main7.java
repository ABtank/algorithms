package less7;

import java.util.List;

public class Main7 {

    public static void main(String[] args) {
        MyGraph myGraph = new MyGraph(5);
        myGraph.addEdge(1, 2);
        myGraph.addEdge(0, 4);
        myGraph.addEdge(1, 4);
        myGraph.addEdge(2, 4);
        myGraph.addEdge(3, 4);
        System.out.println(myGraph.getAdjList(1));
        System.out.println(myGraph.getAdjList(2));
        System.out.println(myGraph.getAdjList(3));
        System.out.println(myGraph.getAdjList(4));


        DepthFirstPaths dfp = new DepthFirstPaths(myGraph, 2);
        System.out.println("dfp.hasPathTo=" + dfp.hasPathTo(0));
        System.out.println("dfp.pathTo=" + dfp.pathTo(0));

        BreadthFirstPath bfp = new BreadthFirstPath(myGraph, 2);
        System.out.println("bfp.hasPathTo=" + bfp.hasPathTo(0));
        System.out.println("bfp.hasPathTo=" + bfp.pathTo(0));
        System.out.println("bfp.hasPathTo=" + bfp.hasPathTo(3));

        MyGraph pentacle = new MyGraph(10); // звезда в круге
        pentacle.addEdge(0,5);
        pentacle.addEdge(0,1);
        pentacle.addEdge(0,6);
        pentacle.addEdge(0,4);
        pentacle.addEdge(1,2);
        pentacle.addEdge(1,7);
        pentacle.addEdge(1,5);
        pentacle.addEdge(2,7);
        pentacle.addEdge(2,8);
        pentacle.addEdge(2,3);
        pentacle.addEdge(3,8);
        pentacle.addEdge(3,9);
        pentacle.addEdge(3,4);
        pentacle.addEdge(4,9);
        pentacle.addEdge(4,6);

        BreadthFirstPath bfpHome = new BreadthFirstPath(pentacle,0);
        System.out.println("bfp.hasPathTo=" + bfpHome.pathTo(8)+
                            " size = "+bfpHome.pathTo(8).size());
    }
}
