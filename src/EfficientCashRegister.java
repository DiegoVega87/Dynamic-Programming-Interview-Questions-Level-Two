import javax.naming.PartialResultException;
import java.util.ArrayList;
import java.util.Arrays;

public class EfficientCashRegister {

    /*
    * As a startup, we are developing a cash register system that can make the fewest number of coins for any amount
    * of money. Given an array coins that stores all available coins (1ct, 2ct etc...)  and the price amount, return the
    * smallest number of coins and bills possible to pay the price. Return -1 if the given coins are not suitable to pay
    * the exact price.
    *
    * Example 1:
    *
    * int[] coins = {1, 5, 10, 25};
    * int price = 76;
    * int expectedOutput = 4;
    *
    * Example 2:
    * int[] coins = {1, 5, 10, 25};
    * int price = 99;
    * int expectedOutput = 9;
    *
    * */
    public static void main(String[] args){

        int[] coins = {1, 5, 10, 25};
        int price = 76;
        System.out.println(calculateMinCoins(coins,price));
    }
    public static int calculateMinCoins(int[] coins, int price){

        Arrays.sort(coins); // Sort the coins array in ascending order
        int[] dp = new int[price + 1]; // Create an array to store the minimum number of coins for each price
        Arrays.fill(dp, Integer.MAX_VALUE); //Initialize the array with max value

        dp[0] = 0; // The minimum number of coins for 0 price;

        for(int i=1; i <= price; i++){
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }

        return dp[price] == Integer.MAX_VALUE ? -1: dp[price];
    }


}
