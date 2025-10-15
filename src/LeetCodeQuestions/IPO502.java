package LeetCodeQuestions;
import java.util.*;
public class IPO502 {
    public static void main(String[] args) {
        int k = 2, w = 0;
        int[] profits = {1, 2, 3}, capital = {0, 1, 1};
        int[][] arr = new int[profits.length][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = profits[i];
            arr[i][1] = capital[i];
        }
        System.out.println(IPO(arr, k, w));
    }

    public static int IPO(int[][] arr, int k, int w) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int i = 0; i < arr.length; i++) {
            while(w >= arr[i][0]){
                pq.add(arr[i]);
                i++;
            }
            if(pq.isEmpty() || k==0){
                return w;
            }
            w+=pq.poll()[1];
            k--;
        }
        return w;
    }
}
