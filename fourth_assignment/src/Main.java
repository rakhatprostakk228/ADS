public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "C", 4);
        graph.addEdge("B", "C", 2);
        graph.addEdge("B", "D", 5);
        graph.addEdge("C", "D", 1);
        graph.addEdge("D", "E", 5);
        graph.addEdge("A", "E", 10);

        System.out.println("BFS from A to D:");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, "A");
        Iterable<Vertex<String>> bfsPath = bfs.pathTo("E");
        if (bfsPath != null) {
            for (Vertex<String> vertex : bfsPath) {
                System.out.println(vertex.getData());
            }
        } else {
            System.out.println("No path found.");
        }

        System.out.println("\nDijkstra from A to D:");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, "A");
        Iterable<Vertex<String>> dijkstraPath = dijkstra.pathTo("E");
        if (dijkstraPath != null) {
            for (Vertex<String> vertex : dijkstraPath) {
                System.out.println(vertex.getData());
            }
        } else {
            System.out.println("No path found.");
        }
    }
}