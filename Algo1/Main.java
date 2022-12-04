package Algo1;

public class Main {
    public static void main(String[] args) {
        //create a graph:
        Graph g = new Graph();
        //create 20 vertices and 50 edges:
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Vertex v3 = new Vertex();
        Vertex v4 = new Vertex();
        Vertex v5 = new Vertex();
        Vertex v6 = new Vertex();
        Vertex v7 = new Vertex();
        Vertex v8 = new Vertex();
        Vertex v9 = new Vertex();
        Vertex v10 = new Vertex();
        Vertex v11 = new Vertex();
        Vertex v12 = new Vertex();
        Vertex v13 = new Vertex();
        Vertex v14 = new Vertex();
        Vertex v15 = new Vertex();
        Vertex v16 = new Vertex();
        Vertex v17 = new Vertex();
        Vertex v18 = new Vertex();
        Vertex v19 = new Vertex();
        Vertex v20 = new Vertex();
        Vertex v21 = new Vertex();
        Vertex v22 = new Vertex();
        Vertex v23 = new Vertex();
        Vertex v24 = new Vertex();
        Vertex v25 = new Vertex();
        Vertex v26 = new Vertex();


        //add vertices to the graph:
        g.addVertex(v1 , 'A');
        g.addVertex(v2 , 'B');
        g.addVertex(v3 , 'C');
        g.addVertex(v4 , 'D');
        g.addVertex(v5 , 'E');
        g.addVertex(v6 , 'F');
        g.addVertex(v7 , 'G');
        g.addVertex(v8 , 'H');
        g.addVertex(v9 , 'I');
        g.addVertex(v10 , 'J');
        g.addVertex(v11 , 'K');
        g.addVertex(v12 , 'L');
        g.addVertex(v13 , 'M');
        g.addVertex(v14 , 'N');
        g.addVertex(v15 , 'O');
        g.addVertex(v16 , 'P');
        g.addVertex(v17 , 'Q');
        g.addVertex(v18 , 'R');
        g.addVertex(v19 , 'S');
        g.addVertex(v20 , 'T');
        g.addVertex(v21 , 'U');
        g.addVertex(v22 , 'V');
        g.addVertex(v23 , 'W');
        g.addVertex(v24 , 'X');
        g.addVertex(v25 , 'Y');
        g.addVertex(v26 , 'Z');




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
        g.addEdge(v7, v8, 7);
        g.addEdge(v7, v9, 9);
        g.addEdge(v7, v12, 14);
        g.addEdge(v8, v9, 10);
        g.addEdge(v8, v10, 15);
        g.addEdge(v9, v10, 11);
        g.addEdge(v9, v12, 2);
        g.addEdge(v10, v11, 6);
        g.addEdge(v11, v12, 9);
        g.addEdge(v13, v14, 7);
        g.addEdge(v13, v15, 9);
        g.addEdge(v13, v18, 14);
        g.addEdge(v14, v15, 10);
        g.addEdge(v14, v16, 15);
        g.addEdge(v15, v16, 11);
        g.addEdge(v15, v18, 2);
        g.addEdge(v16, v17, 6);
        g.addEdge(v17, v18, 9);
        g.addEdge(v19, v20, 7);
        g.addEdge(v19, v1, 9);
        g.addEdge(v19, v4, 14);
        g.addEdge(v20, v1, 10);
        g.addEdge(v20, v4, 15);
        g.addEdge(v20, v5, 11);
        g.addEdge(v20, v6, 2);
        g.addEdge(v20, v7, 6);
        g.addEdge(v20, v8, 9);
        g.addEdge(v21, v22, 7);
        g.addEdge(v21, v23, 9);
        g.addEdge(v21, v26, 14);
        g.addEdge(v22, v23, 10);
        g.addEdge(v22, v24, 15);
        g.addEdge(v23, v24, 11);
        g.addEdge(v23, v26, 2);
        g.addEdge(v24, v25, 6);
        g.addEdge(v25, v26, 9);
        g.addEdge(v1, v7, 7);
        g.addEdge(v1, v13, 9);
        g.addEdge(v1, v19, 14);
        g.addEdge(v2, v8, 10);
        g.addEdge(v2, v14, 15);
        g.addEdge(v2, v20, 11);

        //print the graph:
        System.out.println("Original Graph:");
        g.printGraph();
        //minimum spanning tree:
        Graph mst = Graph.Prim(g);
        System.out.println("\nMST Graph:");
//        //print the minimum spanning tree:
        mst.printGraph();

        mst.addEdge(v1,v3,100);
        //print the edge
        System.out.println("\nAdded Edge:");
        System.out.println(v1.name + "--" + v3.name + " " +"weight: 100 ");
        Graph mst2 = Graph.addedEdgeToMST(mst,mst.getEdge(v1,v3));

        System.out.println("\nMST1 Graph with added edge:");
        mst2.printGraph();


        mst2.addEdge(v1,v3,1);
        //print the edge
        System.out.println("\nAdded Edge:");
        System.out.println(v1.name + "--" + v3.name + " " +"weight: 1 ");


        Graph mst3 = Graph.addedEdgeToMST(mst2,mst2.getEdge(v1,v3));
        System.out.println("\nMST2 Graph with added edge:");
        mst3.printGraph();


    }
}