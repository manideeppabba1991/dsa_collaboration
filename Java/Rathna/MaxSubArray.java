import java.util.Stack;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int maxSum = maxSubArray(arr);
        System.out.println("Maximum sum for the given array is : " + maxSum);
    }

    private static int maxSubArray(int[] arr) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MIN_VALUE);
        for (int k = 1; k < arr.length; k++) {
            for (int i = 0; i < k; i++) {
                sum += arr[i];
            }
            int maxSum = sum;
            for (int j = k; j < arr.length; j++) {// TC = O(n^2) and SC = O(1) without considering result collections.
                maxSum -= arr[j - k];
                maxSum += arr[j];
                if (maxSum > sum) {
                    if (stack.peek() < maxSum) {
                        stack.pop();
                        stack.push(maxSum);
                    }
                } else {
                    if (stack.peek() < sum) {
                        stack.pop();
                        stack.push(sum);
                    }
                }
            }
            sum = 0;
        }
        int totalSum = 0;
        for (int i : arr) {
            totalSum += i;
        }

        return totalSum > stack.peek() ? totalSum : stack.peek();
    }
}
