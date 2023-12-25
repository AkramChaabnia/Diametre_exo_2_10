package up.mi.chaabnia;

import up.mi.chaabnia.WeightedGraph.Edge;
import up.mi.chaabnia.WeightedGraph.Graph;
import up.mi.chaabnia.WeightedGraph.Vertex;

import java.util.*;

public class App {
	private static double findDiameter(Graph graph, int num_v) {
		double maxDiameter = Double.MIN_VALUE;
		boolean[] visited = new boolean[num_v];

		for (int i = 0; i < num_v; i++) {
			if (!visited[i]) {
				double diameter = calculateComponentDiameter(graph, i, num_v);
				if (diameter > maxDiameter) {
					maxDiameter = diameter;
				}
			}
		}

		return maxDiameter;
	}

	private static double calculateComponentDiameter(Graph graph, int start, int num_v) {
		double maxDistance = Double.MIN_VALUE;

		for (int i = 0; i < num_v; i++) {
			LinkedList<Integer> path = Dijkstra(graph, start, i, num_v);

			if (path != null) {
				// Found a path from 'start' to 'i', update maxDistance if needed
				double pathDistance = calculatePathDistance(graph, path);
				if (pathDistance > maxDistance) {
					maxDistance = pathDistance;
					System.out.println("Path from " + start + " to " + i + ": " + path.toString());
					System.out.println("Distance: " + pathDistance);

				}
			} else {
				System.out.println("No path found from " + start + " to " + i + ".");
			}

			resetGraph(graph);
		}

		return maxDistance;
	}

	private static double calculatePathDistance(Graph graph, LinkedList<Integer> path) {
		double distance = 0.0;

		for (int i = 0; i < path.size() - 1; i++) {
			int current = path.get(i);
			int next = path.get(i + 1);

			for (Edge edge : graph.vertexlist.get(current).adjacencylist) {
				if (edge.destination == next) {
					distance += edge.weight;
					break;
				}
			}
		}

		return distance;
	}

	private static void resetGraph(Graph graph) {
		for (Vertex v : graph.vertexlist) {
			v.timeFromSource = Double.POSITIVE_INFINITY;
			v.prev = null;
		}
	}

	private static LinkedList<Integer> Dijkstra(Graph graph, int start, int end, int numberV) {
		PriorityQueue<Vertex> to_visit = new PriorityQueue<>(numberV, Comparator.comparingDouble(v -> v.timeFromSource));

		for (int i = 0; i < numberV; i++) {
			graph.vertexlist.get(i).timeFromSource = Double.MAX_VALUE;
			to_visit.add(graph.vertexlist.get(i));
		}

		graph.vertexlist.get(start).timeFromSource = 0;

		int number_tries = 0;

		while (!to_visit.isEmpty()) {
			Vertex min_v = to_visit.poll();
			if (min_v == null) {
				System.out.println("No minimum vertex found!");
				break;
			}

			number_tries++;

			for (Edge edge : min_v.adjacencylist) {
				int to_try = edge.destination;
				double new_dist = min_v.timeFromSource + edge.weight;

				if (new_dist < graph.vertexlist.get(to_try).timeFromSource) {
					graph.vertexlist.get(to_try).timeFromSource = new_dist;
					graph.vertexlist.get(to_try).prev = min_v;

					to_visit.remove(graph.vertexlist.get(to_try));
					to_visit.add(graph.vertexlist.get(to_try));
				}
			}
		}

		LinkedList<Integer> path = new LinkedList<>();
		path.addFirst(end);
		int current = end;
		while (current != start) {
			Vertex prevVertex = graph.vertexlist.get(current).prev;
			if (prevVertex != null) {
				current = prevVertex.num;
				path.addFirst(current);
			} else {
				break;
			}
		}
		return path;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of vertices: ");
		int numVertices = scanner.nextInt();

		Graph graph = new Graph();

		for (int i = 0; i < numVertices; i++) {
			graph.addVertex();
		}

		System.out.println("Enter the edges in the format: source destination weight");
		System.out.println("(Enter -1 to stop)");

		while (true) {
			int source = scanner.nextInt();
			if (source == -1)
				break;
			int destination = scanner.nextInt();
			double weight = scanner.nextDouble();
			graph.addEdge(source, destination, weight);
		}
		scanner.close();

		double diameter = findDiameter(graph, graph.num_v);
		System.out.println("Diameter of the graph: " + diameter);
	}

}
