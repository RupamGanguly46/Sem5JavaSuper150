package LeetCodeQuestions.Lec54;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import LeetCodeQuestions.Lec54.Is_Graph_Bipartite.BipartitePair;

public class LC_785_Is_Graph_Bipartite {
    class Solution {
    static int[] color;
    // graph is in the form each array represents node, containing all it's neighbours
    public boolean isBipartite(int[][] graph) {
        int numberOfNodes = graph.length;
        // Each index represents node and the color/set it belongs to
        // 0: Not assigned/uncolored, 1: Color A, -1: Color B
        color = new int[numberOfNodes];

        // Checking all nodes
        for(int i=0; i<numberOfNodes; i++){
            // Node is not yet assigned
            if(color[i]==0){
                // Start DFS, assign -1 initially
                if(!dfs(i, graph, -1)){
                    return false;
                }
            }
        }
        // All nodes satisfied condition:
        // Neighbours don't belong to the same set as selected node
        return true;
    }

    boolean dfs(int node, int[][] graph, int currentColor){
        color[node] = currentColor;

        // If assigned, neighbour should not be in same color/set as node, if not assigned, then assign it such that colors should not be same, else it's not possible, dfs will return false and then isBipartite will also return false.
        
        // Checking all neighbours of selected node
        for(int neighbour: graph[node]){
            // Not yet assigned, assign and check furthur
            if(color[neighbour]==0){
                // Check neighbour with color different than current color
                if(!dfs(neighbour, graph, currentColor*-1)){
                    return false;
                }
            }
            // If color of neighbour same as node, return false!
            else if (color[neighbour] == currentColor){
                return false;
            }
        }
        // If for all neighbours, we assigned set perfectly, then we got bipartite graph..
        return true;
    }
}

public class Solution2 {
    public static boolean isBipartite(int[][] graph){
        Queue<BipartitePair> q = new LinkedList<>();
        HashMap<Integer, Integer> visited = new HashMap<>();
        for(int i=0; i<graph.length; i++){
            // vtx
            if(visited.containsKey(i)){
                continue;
            }
            q.add(new BipartitePair(i, 0));
            while(!q.isEmpty()){

                // 1. Remove 
                BipartitePair rp = q.poll();

                // 2. Ignore if already visited
                if(visited.containsKey(rp.vtx)){
                    if(visited.get(rp.vtx)!= rp.dis){
                        return false;
                    }
                    continue;
                }

                // 3. Mark visited
                visited.put(rp.vtx, rp.dis);

                // 4. Self work

                // 5. Add unvisited neighbours
                for(int nbr: graph[rp.vtx]){
                    if(!visited.containsKey(nbr)){
                        q.add(new BipartitePair(nbr, rp.dis + 1));
                    }
                }
            }
        }
        return true;
    }
    
    public static class BipartitePair {
        public int vtx;
        public int dis;
        public BipartitePair(int vtx, int dis){
            this.vtx = vtx;
            this.dis = dis;
        }
    }
}

}
