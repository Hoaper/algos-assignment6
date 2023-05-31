import java.util.*;

public class MyGraph<Vertex> {
    private Map<Vertex, List<Edge<Vertex>>> graph;

    public MyGraph() {
        graph = new HashMap<>();
    }

    public void addEdge(Vertex source, Vertex destination, double weight){
        Edge edge = new Edge(source, destination, weight);
        if (!graph.containsKey(source)) graph.put(source, new ArrayList<>());
        graph.get(source).add(edge);
    }

    public Map<Vertex, Double> dijkstra(Vertex start) {

        Map<Vertex, Double> distances = new HashMap<>();
        for (Vertex node : graph.keySet()) {
            distances.put(node, Double.MAX_VALUE);
        }
        distances.put(start, 0d);

        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        queue.add(start);


        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            for (Edge neighbor : graph.get(currentVertex)) {

                double distance = distances.get(currentVertex) + neighbor.getWeight();


                if (distance < distances.get(currentVertex)) {
                    distances.put(currentVertex, distance);

                    queue.add((Vertex) neighbor.getDest());
                }
            }
        }

        return distances;
    }

}
