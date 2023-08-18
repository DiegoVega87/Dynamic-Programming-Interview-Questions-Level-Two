import java.util.Arrays;

public class SalesPerformance {

    /*
    * As a growing startup, we want to analyze the performance of our sales team. To do this, we need to find the length
    * of the longest increasing sequence of our monthly sales data stored in an integer array. Write a function that
    * takes in the array and returns the length of the longest increasing subsequence. This will help us identify the
    * salesperson with the highest sales growth rate and improve our overall sales performance.
    *
    * Example 1:
    * int[] salesData = {1, 3, 2, 4, 6, 5, 8, 7, 9};
    * int result = longestIncreasingSubsequence(salesData);
    * System.out.println(result); // Output: 6, )
    *
    * Example 2:
    * int[] salesData = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    * int result = longestIncreasingSubsequence(salesData);
    * System.out.println(result); // Output: 1
    *
    * */

    public static void main(String[] args){
        int[] data = {1,3,2,4,6,5,8,7,9};
        System.out.println(longestIncreasingSubsequence(data));
    }
    public static int longestIncreasingSubsequence(int[] salesData){

        int n = salesData.length;
        int[][] dp = new int[n+1][n+1];

        for(int ind=n-1; ind >= 0; ind--){
            for(int prev = ind-1; prev >= -1; prev--){
                int notTake = dp[ind+1][prev + 1];
                int take = 0;
                if(prev == -1 || salesData[ind] > salesData[prev]){
                    take = 1 + dp[ind+1][ind+1];
                }
                dp[ind][prev+1] = Math.max(notTake,take);
            }
        }
        return dp[0][0];
    }

    private static int helper(int[] sales, int ind, int prev, int n, int [][] dp){
        if(ind == n){
            return 0;
        }
        if(dp[ind][prev+1] != -1){
            return dp[ind][prev+1];
        }
        int length = helper(sales, ind+1, prev, n,dp);

        if(prev == -1 || sales[ind] > sales[prev]){
            length = Math.max(length, 1+helper(sales, ind+1, ind, n, dp));
        }

        return dp[ind][prev+1] = length;
    }

}
