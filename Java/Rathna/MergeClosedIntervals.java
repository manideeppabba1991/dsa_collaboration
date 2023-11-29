import java.util.Arrays;
import java.util.Stack;

public class MergeClosedIntervals {
    public static void main(String[] args) {

        int[][] intervals = {{1,4}, {3,6}, {7,9}};
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
        for(int[] out: intervals) {
                System.out.println("Before Resultant interval range: " + "{" + out[0] + "," + out[1] + "}");
        }
        int[][] output = mergerIntervals(intervals);
        for(int[] out: output) {
                System.out.println("Resultant interval range: " + "{" + out[0] + "," + out[1] + "}");
        }
        
    }

    private static int[][] mergerIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0])); // TC = O(n log n) for sorting elements of an array
        Stack<int[]> stack = new Stack<>(); // SC = O(n) in worst case and O(1) in best case
        int size = intervals.length;

        //base condition
        if(size == 1) {
            return intervals;
        }
        if(stack.isEmpty()) {
            stack.add(intervals[0]);
        }


        for(int i = 1; i < size; i++) { //TC = O(n-1)
            int[] insertedInterval = stack.peek();
         if(intervals[i][0] <= insertedInterval[1]) {
                stack.pop();
                if(intervals[i][1] > insertedInterval[1]) {
                    insertedInterval[1] = intervals[i][1];
                }
                stack.push(insertedInterval);
            } else if(intervals[i][0] > insertedInterval[1]) {
                stack.push(intervals[i]);
            }
        }

        int stackSize = stack.size();
        int[][] output = new int[stackSize][2]; //Overall: Final TC = O(n log n) and SC = O(n)
        return stack.toArray(output);
    }
}