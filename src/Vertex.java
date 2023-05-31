import java.util.HashMap;
import java.util.Map;
public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjVertices;

    public void addAdjVertex(Vertex<V> destination, double weight ){
        adjVertices.put(destination, weight);
    }

    public Vertex(V data) {
        this.data = data;
        adjVertices = new HashMap<>();
    }
}
