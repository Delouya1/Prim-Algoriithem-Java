package Algo1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Graph {
    public List<Vertex> vertices;
    public List<Edge> edges;

    public Graph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public static Graph Prim(Graph g) {
        Graph mst = new Graph();

        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.key));

        for (Vertex v : g.vertices) {
            v.key = Integer.MAX_VALUE;
            v.Pi = null;
            pq.add(v);
        }

        Vertex r = g.vertices.get(0);
        r.key = 0;
        pq.remove(r);
        pq.add(r);

        while (!pq.isEmpty()) {
            Vertex u = pq.poll();
            mst.addVertex(u, u.name);
            if (u.Pi != null) {
                mst.addEdge(u, u.Pi, g.getEdge(u, u.Pi).weight);
            }
            for (Vertex v : g.getNeighbors(u)) {
                if (pq.contains(v) && g.getEdge(u, v).weight < v.key) {
                    pq.remove(v);
                    v.Pi = u;
                    v.key = g.getEdge(u, v).weight;
                    pq.add(v);
                }
            }
        }


        for (Vertex v : mst.vertices) {
            v.edges.removeIf(edge -> !mst.edges.contains(edge));
        }

        return mst;

    }

    public static Graph addedEdgeToMST(Graph mst, Edge e) {
        //create a list of vertices that are in the cycle:
        List<Edge> cycle = new ArrayList<>();
        cycle.add(e);
        Vertex v = e.v1;
        Vertex u = e.v2;
        while (!u.equals(v)) {
            Edge edge = mst.getEdge(u, u.Pi);
            cycle.add(edge);
            u = u.Pi;
        }
        //finds the edge with the largest weight in the cycle and remove it:
        Edge max = cycle.get(0);
        for (Edge edge : cycle) {
            if (edge.weight > max.weight) {
                max = edge;
            }
        }
        //return mst with the edge removed:
        mst.edges.remove(max);
        mst.getEdge(max.v1, max.v2).weight = Integer.MAX_VALUE;
        mst.getEdge(max.v2, max.v1).weight = Integer.MAX_VALUE;


        return mst;


    }

    public void addVertex(Vertex v, char name) {
        vertices.add(v);
        v.name = name;

    }

    public void addEdge(Vertex v1, Vertex v2, int weight) {
        Edge e = new Edge(v1, v2, weight);
        edges.add(e);
        v1.edges.add(e);
        v2.edges.add(e);
    }

    public List<Vertex> getNeighbors(Vertex v) {
        List<Vertex> neighbors = new ArrayList<>();
        for (Edge e : v.edges) {
            if (e.v1.equals(v)) {
                neighbors.add(e.v2);
            }
            if (e.v2.equals(v)) {
                neighbors.add(e.v1);
            }
        }
        return neighbors;
    }

    //getEdge returns the edge connecting two vertices:
    public Edge getEdge(Vertex v1, Vertex v2) {
        for (Edge e : v1.edges) {
            if (e.v1.equals(v1) && e.v2.equals(v2)) {
                return e;
            }
            if (e.v1.equals(v2) && e.v2.equals(v1)) {
                return e;
            }
        }
        return null;
    }

    //printGraph prints the graph and weight of each edge:
    public void printGraph() {
        for (Edge e : edges) {
            System.out.println(e.v1.name + " " + e.v2.name + " " + e.weight);
        }
    }

}

