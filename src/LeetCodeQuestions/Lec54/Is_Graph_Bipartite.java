package LeetCodeQuestions.Lec54;
import java.util.*;
public class Is_Graph_Bipartite {
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

    public static void main(String[] args){
        // Example 1: bipartite (0-1-2, 1-3)
        int[][] g1 = new int[][]{
            {1},    // 0
            {0,2,3},// 1
            {1},    // 2
            {1}     // 3
        };

        // Example 2: not bipartite (triangle 0-1-2-0)
        int[][] g2 = new int[][]{
            {1,2},
            {0,2},
            {0,1}
        };

        System.out.println("g1 bipartite? " + isBipartite(g1)); // true
        System.out.println("g2 bipartite? " + isBipartite(g2)); // false
    }
}

