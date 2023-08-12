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

        int n = coins.length;
        int[][] memo = new int[n][price + 1];

        for(int[] row : memo){
            Arrays.fill(row, -1);
        }

        return calculateMinCoins(coins, n-1, price, memo);
    }

    private static int calculateMinCoins(int[] coins, int index, int target, int[][] memo){


        if(index == 0){
            if(target % coins[0] == 0){
                return target/coins[0];
            }else{
                return -1;
            }
        }

        if(memo[index][target] != -1){
            return memo[index][target];
        }

        int notTake = calculateMinCoins(coins, index - 1, target, memo);
        int take = Integer.MAX_VALUE;

        if(coins[index] <= target){
            take =  1 + calculateMinCoins(coins, index, target - coins[index], memo);
        }

        return memo[index][target] = Math.min(notTake, take);
    }
}
