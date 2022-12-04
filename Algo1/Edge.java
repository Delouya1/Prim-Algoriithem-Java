package Algo1;

public class Edge {
    public Vertex v1, v2;
    public int weight;


    public Edge(Vertex v1, Vertex v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;

    }


    public Edge(Edge e) {
        this.v1 = e.v1;
        this.v2 = e.v2;
        this.weight = e.weight;
    }
}
