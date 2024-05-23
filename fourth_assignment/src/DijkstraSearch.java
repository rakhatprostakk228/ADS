import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private Map<Vertex<V>, Double> distTo;
    private Map<Vertex<V>, Vertex<V>> edgeTo;
    private PriorityQueue<VertexDist<V>> pq;

    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        Vertex<V> sourceVertex = graph.getVertex(source);
        distTo = new HashMap<>();
        edgeTo = new HashMap<>();
        pq = new PriorityQueue<>(Comparator.comparing(VertexDist::getDist));

        for (Vertex<V> vertex : graph.getVertices().values()) {
            distTo.put(vertex, Double.POSITIVE_INFINITY);
        }
        distTo.put(sourceVertex, 0.0);

        pq.add(new VertexDist<>(sourceVertex, 0.0));
        while (!pq.isEmpty()) {
            relax(pq.poll().getVertex());
        }
    }

    private void relax(Vertex<V> vertex) {
        for (Map.Entry<Vertex<V>, Double> entry : vertex.getAdjacentVertices().entrySet()) {
            Vertex<V> neighbor = entry.getKey();
            double weight = entry.getValue();
            if (distTo.get(neighbor) > distTo.get(vertex) + weight) {
                distTo.put(neighbor, distTo.get(vertex) + weight);
                edgeTo.put(neighbor, vertex);
                pq.add(new VertexDist<>(neighbor, distTo.get(neighbor)));
            }
        }
    }

    @Override
    public boolean hasPathTo(V destination) {
        Vertex<V> destVertex = distTo.keySet().stream()
                .filter(v -> v.getData().equals(destination))
                .findFirst()
                .orElse(null);
        return distTo.getOrDefault(destVertex, Double.POSITIVE_INFINITY) != Double.POSITIVE_INFINITY;
    }

    @Override
    public Iterable<Vertex<V>> pathTo(V destination) {
        Vertex<V> destVertex = distTo.keySet().stream()
                .filter(v -> v.getData().equals(destination))
                .findFirst()
                .orElse(null);
        if (destVertex == null || !hasPathTo(destination)) return null;
        LinkedList<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> x = destVertex; x != null; x = edgeTo.get(x)) {
            path.push(x);
        }
        return path;
    }

    private static class VertexDist<V> {
        private Vertex<V> vertex;
        private double dist;

        public VertexDist(Vertex<V> vertex, double dist) {
            this.vertex = vertex;
            this.dist = dist;
        }

        public Vertex<V> getVertex() {
            return vertex;
        }

        public double getDist() {
            return dist;
        }
    }
}