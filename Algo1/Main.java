package Algo1;

public class Main {
    public static void main(String[] args) {
        //create a graph:
        Graph g = new Graph();
        //create vertices:
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Vertex v3 = new Vertex();
        Vertex v4 = new Vertex();
        Vertex v5 = new Vertex();
        Vertex v6 = new Vertex();

        //add vertices to the graph:
        g.addVertex(v1, 'A');
        g.addVertex(v2, 'B');
        g.addVertex(v3, 'C');
        g.addVertex(v4, 'D');
        g.addVertex(v5, 'E');
        g.addVertex(v6, 'F');

        //add edges to the graph:
        g.addEdge(v1, v2, 7);
        g.addEdge(v1, v3, 9);
        g.addEdge(v1, v6, 14);
        g.addEdge(v2, v3, 10);
        g.addEdge(v2, v4, 15);
        g.addEdge(v3, v4, 11);
        g.addEdge(v3, v6, 2);
        g.addEdge(v4, v5, 6);
        g.addEdge(v5, v6, 9);

        //print the graph:
        System.out.println("Original Graph:");
        g.printGraph();
        //minimum spanning tree:
        Graph mst = Graph.Prim(g);
        System.out.println("\nMST Graph:");
//        //print the minimum spanning tree:
        mst.printGraph();

        mst.addEdge(v3, v5, 9);

        Graph newMST = Graph.addedEdgeToMST(mst, mst.getEdge(v3, v5));

        System.out.println("\nNew MST Graph:");
        newMST.printGraph();

    }
}