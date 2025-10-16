package MonuBhaiyaPractice.Lec53;

public class Test_Graph_2 {
    public static void main(String[] args) {
        // create a graph with 6 vertices (0..5)
        Graph_2 g = new Graph_2(6);

        // add edges (undirected, cost = 1)
        g.AddEdge(0, 1, 1);
        g.AddEdge(0, 2, 1);
        g.AddEdge(1, 3, 1);
        g.AddEdge(2, 4, 1);
        g.AddEdge(4, 5, 1);

        // BFS tests
        System.out.println("BFS 0 -> 5 (expected true): " + g.BFS(0, 5));
        System.out.println("BFS 3 -> 5 (expected false): " + g.BFS(3, 5));

        // DFS tests (iterative DFS implemented in Graph_2)
        System.out.println("DFS 0 -> 5 (expected true): " + g.DFS(0, 5));
        System.out.println("DFS 3 -> 5 (expected false): " + g.DFS(3, 5));

        // BFT and DFT (will print traversal order)
        System.out.print("BFT (breadth-first traversal): ");
        g.BFT();

        System.out.print("DFT (depth-first traversal): ");
        g.DFT();
    }
}
