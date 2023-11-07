import java.util.Stack;

public class SlidingWindowBuyAndSellStocks {
    public static void main(String[] args) {

        //Sliding Window
        int[] arr = {3, -6, 34, 11, 12, 5, 4};
        int total = 0;
        Stack<Integer> resultStack = new Stack<>();
        int k = 3;
        for(int i = 0; i < k; i++) {
            total += arr[i];
        }
        resultStack.push(total);
        for(int j = k; j < arr.length; j++) {//TC = O(n), SC = O(n) when result is considered and O(1) when not considered
            total -= arr[j-k];
            total += arr[j];
            resultStack.push(total);
        }
        System.out.println("Sum of consecutive " + k + " elements of the array is " + resultStack);


        //Buy-sell stocks -- follow-up return indexes
        int[] stockPrices = {12, 14, 4, 6, 11, 3, 5, 9, 2};
        int buyPrice = stockPrices[0];
        int profit = 0;
        for(int i = 1; i < stockPrices.length; i++) {//TC = O(n), SC = O(1)
            int tempProfit = stockPrices[i] - buyPrice;
            profit = Math.max(tempProfit,profit);
            buyPrice = Math.min(stockPrices[i], buyPrice);
        }
        System.out.println("Max Profit: " + profit);

    }
}
