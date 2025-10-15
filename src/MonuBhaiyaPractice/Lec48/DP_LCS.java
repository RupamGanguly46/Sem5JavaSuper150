//package MonuBhaiyaPractice;
//
//public class DP_LCS {
//    public static int LCS(String s1,String s2, int i, int j, int[][] dp){
//        if(i == s1.length() || j == s2.length()){
//            return 0;
//        }
//        if(dp[i][j] != -1){
//            return dp[i][j];
//        }
//        int ans = 0;
//        if(s1.charAt(i) == s2.charAt(j)){
//            ans = 1 + LCS(s1, s2, i+1, j+1, dp);
//        }
//        else{
//            int f =  LCS(s1, s2, i+1, j, dp);
//            int s = LCS(s1, s2, i, j+1, dp);
//            ans = Math.max(f, s);
//        }
//        return ans;w
//    }
//
//    public static int LCSBottomUp(String s1, String s2){
//        int[][] dp = new int[s1.length()+1][s2.length()+1];
//        for(int i = 1; i <= dp.length; i++) {
//            for(int j = 1; j < dp[0].length; j++) {
//                int ans = 0;
//                if(s1.charAt(i-1) == s2.charAt(j-1)){
//                    ans = 1 + dp[i-1][j-1];
//                }
//                else{
//                    int f = dp[i-1][j];
//                    int s = dp[i][j-1];
//                    int ans = Math.max(f, s);
//                }
//                dp[i][j] = ans;
//            }
//        }
//        return dp[dp.length -1][dp[0].length - 1];
//    }
//}

package MonuBhaiyaPractice.Lec48;

import java.util.Arrays;

public class DP_LCS {

    // Recursive + Memoization approach
    public static int LCS(String s1, String s2, int i, int j, int[][] dp) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = 1 + LCS(s1, s2, i + 1, j + 1, dp);
        } else {
            int f = LCS(s1, s2, i + 1, j, dp);
            int s = LCS(s1, s2, i, j + 1, dp);
            ans = Math.max(f, s);
        }
        return dp[i][j] = ans; // ✅ store result in dp
    }

    // Bottom-up DP (Tabulation) approach
    public static int LCSBottomUp(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    // Main method to test
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";

        // Recursive + Memoization
        int[][] dp = new int[s1.length()][s2.length()];
        for (int[] row : dp) Arrays.fill(row, -1);
        System.out.println("LCS (Memoization): " + LCS(s1, s2, 0, 0, dp));

        // Bottom-up DP
        System.out.println("LCS (Bottom-Up): " + LCSBottomUp(s1, s2));
    }
}
