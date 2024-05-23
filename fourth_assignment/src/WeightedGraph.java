import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V> {
    private Map<V, Vertex<V>> vertices;

    public WeightedGraph() {
        this.vertices = new HashMap<>();
    }

    public Vertex<V> addVertex(V data) {
        Vertex<V> vertex = new Vertex<>(data);
        vertices.put(data, vertex);
        return vertex;
    }

    public void addEdge(V source, V destination, double weight) {
        Vertex<V> sourceVertex = vertices.get(source);
        Vertex<V> destVertex = vertices.get(destination);

        if (sourceVertex != null && destVertex != null) {
            sourceVertex.addAdjacentVertex(destVertex, weight);
            destVertex.addAdjacentVertex(sourceVertex, weight);
        }
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public Map<V, Vertex<V>> getVertices() {
        return vertices;
    }
}