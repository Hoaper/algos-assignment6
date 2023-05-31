import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyGraph<Vertex> {
    private Map<Vertex, List<Edge<Vertex>>> adjList;

    public MyGraph() {
        adjList = new HashMap<>();
    }

    public void addEdge(Vertex source, Vertex destination, double weight){
        Edge edge = new Edge(source, destination, weight);
        adjList.get(source).add(edge);
    }



}
