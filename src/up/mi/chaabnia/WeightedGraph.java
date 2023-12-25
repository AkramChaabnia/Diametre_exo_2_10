package up.mi.chaabnia;

import java.util.ArrayList;
import java.util.LinkedList;

public class WeightedGraph {
    static class Edge {
        int source;
        int destination;
        double weight;

        public Edge(int source, int destination, double weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Vertex {
        double indivTime;
        double timeFromSource;
        Vertex prev;
        LinkedList<Edge> adjacencylist;
        int num;

        public Vertex(int num) {
            this.indivTime = Double.POSITIVE_INFINITY;
            this.timeFromSource = Double.POSITIVE_INFINITY;
            this.prev = null;
            this.adjacencylist = new LinkedList<>();
            this.num = num;
        }

        public void addNeighbor(Edge e) {
            this.adjacencylist.addFirst(e);
        }
    }

    static class Graph {
        ArrayList<Vertex> vertexlist;
        int num_v = 0;

        Graph() {
            vertexlist = new ArrayList<>();
        }

        public void addVertex(double indivTime) {
            Vertex v = new Vertex(num_v);
            v.indivTime = indivTime;
            v.num = num_v;
            vertexlist.add(v);
            num_v++;
        }

        public void addEdge(int source, int destination, double weight) {
            Edge edge = new Edge(source, destination, weight);
            vertexlist.get(source).addNeighbor(edge);
        }
    }

}
