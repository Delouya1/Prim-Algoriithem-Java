package Algo1;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    public List<Edge> edges;
    public char name;
    public Vertex Pi;
    public int key;


    public Vertex() {
        edges = new ArrayList<>();
        this.key = Integer.MAX_VALUE;

    }


    public Vertex(Vertex v) {
        this.edges = new ArrayList<>();
        this.name = v.name;
        this.Pi = v.Pi;
        this.key = v.key;
    }
}
