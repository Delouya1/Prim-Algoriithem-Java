package Algo1;
public class Edge {
    //create an Edge class that holds two vertices:
    public Vertex v1, v2;
    public int weight;


    public Edge(Vertex v1, Vertex v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;

    }
    //create a method that returns the other vertex of an edge:
    public Vertex getOtherVertex(Vertex v) {
        if (v.equals(v1)) {
            return v2;
        }
        if (v.equals(v2)) {
            return v1;
        }
        return null;
    }
    //create a method that returns the weight of an edge:
    public int getWeight() {
        return weight;
    }

}
