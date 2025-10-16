// Graph never disconnected and acyclic is valid tree!
// Either use BFT or DFT
// We won't use hashmap as input graphs are unweighted
import java.util.*;
public class LC_261_Graph_Valid_Tree{
    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{3,4}};
        int n = 5;
        System.out.println(validTree(n, edges));
    }
    public static boolean validTree(int n, int[][] edges){
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(i, new ArrayList<>());
        }
        // In the map, there are keys 0, 1, 2, .. representing vertices and lists representing
        // list of connected/neighbouring vertices

        for(int i=0; i<edges.length; i++){
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            // map.get(v1) will give value array list for key=v1
            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }
        return BFT(map);
    }

    public static Boolean BFT(HashMap<Integer, List<Integer>> map){
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int c=0;
        for(int src: map.keySet()){
            if(visited.contains(src)){continue;}
            c++; // Count component
            q.add(src);
            while(!q.isEmpty()){
                // 1. Remove
                int r = q.poll();

                // 2. Ignore if already visited
                if(visited.contains(r)){
                    return false; // Cycle found
                }

                // 3. Mark visited
                visited.add(r);

                // 4. Self work
                // System.out.print(r + " ");

                // 5. Add unvisited numbers
                for(int numbers: map.get(r)){
                    if(!visited.contains(numbers)){
                        q.add(numbers);
                    }
                }
            }
        }
        // System.out.println();
        return c==1;
    }
}