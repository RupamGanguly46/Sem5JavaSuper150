import java.util.*;
public class Practice {
    public static void main(String[] args) {
        // 4 edges represented by 2 vertices who are connected
        int[][] input = new int[4][2];
        // Number of vertices
        int n = 5;
        System.out.println(valid(n, input));
    }
    public static Boolean valid(int n, int[][] input){
        // Map, with key = vertex, value = list of neighbouring/conected vertices
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        // Add all vertices with new seperate arraylists and fill the map
        for(int i=0; i<n; i++){
            map.put(i, new ArrayList<>());
        }

        // Fill the lists in map with neighbors
        // Pick every edge/relationship, extract both vertices and fill them as each other's neighbours
        for(int i=0; i<input.length; i++){
            int v1 = input[i][0];
            int v2 = input[i][1];
            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }
        
        // Now I have my Graph! 

    }
}
