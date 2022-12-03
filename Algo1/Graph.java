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

    public List<Vertex> getVertices() {
        return vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public int getWeight(Edge e) {
        return e.weight;
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

    public List<Edge> getEdges(Vertex v) {
        return v.edges;

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
        return mst;


    }

    public static Graph addVertex(Graph mst, Vertex v, int weight) {
        Graph newMst = new Graph();
        for (Vertex u : mst.vertices) {
            newMst.addVertex(u, u.name);
        }
        newMst.addVertex(v, v.name);
        for (Edge e : mst.edges) {
            newMst.addEdge(e.v1, e.v2, e.weight);
        }
        Edge minEdge = null;
        for (Edge e : mst.edges) {
            if (minEdge == null || e.weight < minEdge.weight) {
                minEdge = e;
            }
        }


        assert minEdge != null;
        newMst.addEdge(minEdge.v1, v, weight);
        return newMst;
    }


    public  Graph removeCycle(Graph mst, Edge e) {
        //look for the cycle that was created by adding the edge:
        List<Vertex> cycle = new ArrayList<>();
        Vertex v = e.v1;
        cycle.add(v);
        //write notes on this:
        while (!v.equals(e.v2)) { //while v is not the second vertex of the edge
            for (Edge edge : mst.getEdges(v)) { //getEdges returns the edges of a vertex
                if (!cycle.contains(edge.getOtherVertex(v))) { //return the other vertex of an edge
                    v = edge.getOtherVertex(v);
                    cycle.add(v); //add the vertex to the cycle
                    break;
                }
            }
        }

        //find the edge with the highest weight in the cycle:
        Edge maxEdge = null;
        for (Vertex u : cycle) {
            for (Edge edge : mst.getEdges(u)) {
                if (cycle.contains(edge.getOtherVertex(u))) {
                    if (maxEdge == null || edge.weight > maxEdge.weight) {
                        maxEdge = edge;
                    }
                }
            }
        }
        //remove the edge with the highest weight from the cycle:
        mst.edges.remove(maxEdge);
        return mst;
    }






    //printGraph prints the graph and weight of each edge:
    public void printGraph() {
        for (Edge e : edges) {
            System.out.println(e.v1.name + " " + e.v2.name + " " + e.weight);
        }
    }




}

