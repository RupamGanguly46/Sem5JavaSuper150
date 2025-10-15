package MonuBhaiyaPractice.Lec49;

public class KnapsackZeroOne {
    public static void main(String[] args){
        int cap = 4;
        int[] wt = {1, 2, 3, 2, 2};
        int[] val = {8, 4, 0, 5, 3};
    }
    public static int Knapsack(int[] wt, int[] val, int cap, int i){
        int inc = 0, exc = 0;
        if(cap>=wt[i]){
            inc = val[i] + Knapsack(wt, val, cap-wt[i], i+1);
        }
        exc = Knapsack(wt, val, cap, i+1);
        return Math.max(inc, exc);
    }
}
