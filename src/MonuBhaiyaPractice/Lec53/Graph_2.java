package MonuBhaiyaPractice.Lec53;

import java.util.*;

public class Graph_2{
    private HashMap<Integer, HashMap<Integer, Integer>> map;

    public Graph_2(int v){
        map = new HashMap<>();
        for(int i = 0; i < v; i++) {
            map.put(i, new HashMap<>());
        }
    }

    public void AddEdge(int v1, int v2, int cost){
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }

    public boolean BFS(int src, int des){
        // des => destination
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(src);
        while(!q.isEmpty()){
            // 1. Remove
            int r = q.poll();

            // 2. Ignore if already visited
            if(visited.contains(r)){
                continue;
            }

            // 3. Mark visited
            visited.add(r);

            // 4. Self work
            if(r==des){
                return true;
            }

            // 5. Add unvisited numbers
            for(int numbers: map.get(r).keySet()){
                if(!visited.contains(numbers)){
                    q.add(numbers);
                }
            }
        }
        // if destination wasn't found
        return false;
    }

    public boolean DFS(int src, int des){
        Stack<Integer> st = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        st.push(src);
        while(!st.isEmpty()){
            // 1. Remove
            int r = st.pop();

            // 2. Ignore if already visited
            if(visited.contains(r)){
                continue;
            }

            // 3. Mark visited
            visited.add(r);

            // 4. Self work
            if(r==des){
                return true;
            }

            // 5. Add unvisited numbers
            for(int numbers: map.get(r).keySet()){
                if(!visited.contains(numbers)){
                    st.push(numbers);
                }
            }
        }
        // if destination wasn't found
        return false;
    }

    public void BFT(){
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int src: map.keySet()){
            if(visited.contains(src)){continue;}
            q.add(src);
            while(!q.isEmpty()){
                // 1. Remove
                int r = q.poll();

                // 2. Ignore if already visited
                if(visited.contains(r)){
                    continue;
                }

                // 3. Mark visited
                visited.add(r);

                // 4. Self work
                System.out.print(r + " ");

                // 5. Add unvisited numbers
                for(int numbers: map.get(r).keySet()){
                    if(!visited.contains(numbers)){
                        q.add(numbers);
                    }
                }
            }
        }
        System.out.println();
    }

    public void DFT(){
        Stack<Integer> st = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int src: map.keySet()){
            if(visited.contains(src)){continue;}
            st.push(src);
            while(!st.isEmpty()){
                // 1. Remove
                int r = st.pop();

                // 2. Ignore if already visited
                if(visited.contains(r)){
                    continue;
                }

                // 3. Mark visited
                visited.add(r);

                // 4. Self work
                System.out.print(r + " ");

                // 5. Add unvisited numbers
                for(int numbers: map.get(r).keySet()){
                    if(!visited.contains(numbers)){
                        st.push(numbers);
                    }
                }
            }
        }
        System.out.println();
    }

}