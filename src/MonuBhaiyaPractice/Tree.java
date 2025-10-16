package MonuBhaiyaPractice;

import java.util.HashMap;

public class Tree {
    private HashMap<Integer, HashMap<Integer, Integer>> map;

    public Tree(int v){
        map = new HashMap<>();
        for(int i = 0; i < v; i++){
            map.put(i, new HashMap<>());
        }
    }

    public void AddEdge(int v1, int v2, int cost){
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }
    // public boolean ContainsEdge(int v1, int v2){
        
    // }
    public boolean ContainsVertex(int v1){
        return map.containsKey(v1);
    }
    public int NoOfEdge(){
        int sum = 0;
        for(int vtx : map.keySet()){
            sum =  sum + map.get(vtx).size();
        }
        return sum/2;
    }
}
