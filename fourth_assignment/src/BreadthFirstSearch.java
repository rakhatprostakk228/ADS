import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    private Map<Vertex<V>, Boolean> marked;
    private Map<Vertex<V>, Vertex<V>> edgeTo;
    private Vertex<V> source;

    public BreadthFirstSearch(WeightedGraph<V> graph, V source) {
        this.source = graph.getVertex(source);
        marked = new HashMap<>();
        edgeTo = new HashMap<>();
        bfs(this.source);
    }

    private void bfs(Vertex<V> source) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(source);
        marked.put(source, true);

        while (!queue.isEmpty()) {
            Vertex<V> v = queue.poll();
            for (Vertex<V> w : v.getAdjacentVertices().keySet()) {
                if (!marked.containsKey(w) || !marked.get(w)) {
                    queue.add(w);
                    marked.put(w, true);
                    edgeTo.put(w, v);
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(V destination) {
        return marked.keySet().stream()
                .anyMatch(v -> v.getData().equals(destination));
    }

    @Override
    public Iterable<Vertex<V>> pathTo(V destination) {
        Vertex<V> destVertex = marked.keySet().stream()
                .filter(v -> v.getData().equals(destination))
                .findFirst()
                .orElse(null);
        if (destVertex == null || !hasPathTo(destination)) return null;

        LinkedList<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> x = destVertex; x != null && x != source; x = edgeTo.get(x)) {
            path.push(x);
        }
        path.push(source);
        return path;
    }
}