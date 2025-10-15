package MonuBhaiyaPractice.Lec48;

import java.util.Arrays;

public class CoinChangeII {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        int[][] dp = new int[amount+1][coins.length];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        System.out.println(CoinChange(coins, amount, 0, dp));
    }

    public static int CoinChange(int[] coin, int amount, int i, int[][] dp) {
        if(amount == 0) return 1;
        if(i == coin.length) return 0;
        if(dp[amount][i] != -1){
            return dp[amount][i];
        }
        int inc = 0, exc = 0;
        if(amount >= coin[i]){
            inc = CoinChange(coin, amount - coin[i], i, dp);
        }
        exc =  CoinChange(coin, amount, i+1, dp);
        return dp[amount][i] = inc + exc;
    }

//    public static int CoinChangeBU(int[] coin, int amount){
//        int[][] dp = new int[amount+1][coin.length];
//        for(int i = 0; i < dp.length; i++){
//            dp[i][0] = 1;
//        }
//    }
}
