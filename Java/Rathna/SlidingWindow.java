import java.util.Stack;

public class SlidingWindow {

    // Sliding window is a design pattern followed to solve some kind of problems
    // where target size is fixed such as sum of k consecutive elements in an array,
    // k length substrings possible repated chars (substring) in a given string (DNA
    // Seq), fruits into
    // basket (only 1 type of fruit is allowed in a basket).

    // Pseudo code: Sample Question: sum of 3 consecutive elements in an array
    // when target = k given, find the sum of first k elements (example: window size
    // =
    // 3, elements in indexes 0..2)
    // now slide the window by 1 element by removing 0th element from sum and adding
    // k + 1 element to sum (sum - arr[0] and sum + arr[3])
    // repeat above step until end of an array

    // Time Complexity: We travel through n elements in an array only once...
    // TC = O(n)
    // Space Complexity: Depends on the problem, but in general we don't need data
    // structures to hold results. SC = O(1)

    // Example: Fruits into basket problem,
    // sum of consecutive k elements of an array,
    // Buy and sell stocks.

    public static void main(String[] args) {
        // Sliding Window
        int[] arr = { 3, -6, 34, 11, 12, 5, 4 };
        int k = 3;
        Stack<Integer> result = sumOfKElements(arr, k);
        System.out.println("Sum of 3 cons elements of array: " + result);

    }

    private static Stack<Integer> sumOfKElements(int[] arr, int k) {
        int total = 0;
        Stack<Integer> result = new Stack<>();

        for (int i = 0; i < k; i++) {
            total += arr[i];
        }

        result.push(total);
        int tempSum = total;

        for (int j = k; j < arr.length; j++) {
            tempSum = tempSum - arr[j - k];
            tempSum = tempSum + arr[j];
            result.push(tempSum);
        }
        return result;
    }

}
