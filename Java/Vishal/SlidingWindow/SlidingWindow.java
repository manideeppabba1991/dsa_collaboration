package SlidingWindow;

public class SlidingWindow {

    public int[] slidingWindowSum(int[] arr, int k) {
        int sum = 0;
        int counter = 0;
        int[] arrResult = new int[arr.length-k+1];
        for(int i=0; i<k; i++) {
            sum = sum + arr[i];
        }
        arrResult[counter] = sum;
        for(int j=k; j<arr.length; j++) {
            sum = sum - arr[j-k];
            sum = sum + arr[j];
            counter++;
            arrResult[counter] = sum;
        }
        return arrResult;
    }

    public int maxSubArray(int[] arr) {
        int runningSum = arr[0];
        int maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {

            if (runningSum < 0) {
                runningSum = arr[i];
            } else {
                runningSum = runningSum + arr[i];
            }
            maxSum = Math.max(runningSum, maxSum);
        }
        return maxSum;
    }

    public int buyAndSellStock(int[] stockPrice) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i=0; i<stockPrice.length; i++) {
            if (stockPrice[i] < min) {
                min = stockPrice[i];
            }
            maxProfit = Math.max(maxProfit, stockPrice[i] - min);
        }
        return maxProfit;
    }
}
