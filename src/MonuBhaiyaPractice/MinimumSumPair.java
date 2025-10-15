package MonuBhaiyaPractice;
import java.util.*;
public class MinimumSumPair {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++){
            pq.add(arr[i]);
        }
        int sum = 0;
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            sum = a+b;
            pq.add(a+b);
        }
        System.out.println(pq);
    }
}
