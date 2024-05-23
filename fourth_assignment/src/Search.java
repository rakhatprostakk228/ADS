public interface Search<V> {
    boolean hasPathTo(V destination);
    Iterable<Vertex<V>> pathTo(V destination);
}