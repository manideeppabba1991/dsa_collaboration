import java.util.Arrays;
import java.util.Stack;

public class MergeClosedIntervals {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 4 }, { 3, 6 }, { 7, 9 } };

        int[][] output = mergeIntervalsForUnsortedArray(intervals); // TC = O(n log n) and SC = O(n)
        for (int[] out : output) {
            System.out.println("Merge Intervals - Resultant interval range: " + "{" + out[0] + "," + out[1]
                    + "}");
        }
        System.out.println("==============================");

        int[][] newIntervals = { { 1, 5 } };
        int[] newInterval = { 2, 7 };

        int[][] result = insert(newIntervals, newInterval); // TC = O(n log n) and SC = O(n)
        for (int[] res : result) {
            System.out.println("Approach 1 - First insert new interval, sort and merge if overlaps exists: " + "{"
                    + res[0] + "," + res[1]
                    + "}");
        }
        System.out.println("==============================");

        int[][] newResult = linearSearchInsert(newIntervals, newInterval); // TC = O(n) and SC = O(n)
        for (int[] res : newResult) {
            System.out.println(
                    "Approach 2 - First figure out correct spot/position for newInterval in the sortedArray and merge if overlaps exists: "
                            + "{" + res[0] + "," + res[1] + "}");
        }
        System.out.println("==============================");

        int[][] latestIntervalsArray = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] latestInterval = { 4, 8 };

        int[][] latestResult = mergeWhileInserting(latestIntervalsArray, latestInterval); // TC = O(n) and SC = O(n)
        for (int[] res : latestResult) {
            System.out.println("Approach 3 - Merge while inserting: " + "{" + res[0] + "," + res[1] + "}");
        }

    }

    private static int[][] mergeWhileInserting(int[][] latestIntervalsArray, int[] latestInterval) {
        Stack<int[]> stack = new Stack<>();
        int i = 0;
        int size = latestIntervalsArray.length;

        while (i < size && latestIntervalsArray[i][1] < latestInterval[0]) {
            stack.push(latestIntervalsArray[i++]);
        }

        while (i < size && latestIntervalsArray[i][0] <= latestInterval[1]) {
            latestInterval[0] = Math.min(latestInterval[0], latestIntervalsArray[i][0]);
            latestInterval[1] = Math.max(latestInterval[1], latestIntervalsArray[i][1]);
            i++;
        }

        stack.push(latestInterval);

        while (i < size) {
            stack.push(latestIntervalsArray[i++]);
        }

        int stackSize = stack.size();
        int[][] output = new int[stackSize][2]; // Overall: Final TC = O(n) and SC = O(n)
        return stack.toArray(output);
    }

    private static int[][] linearSearchInsert(int[][] intervals, int[] newInterval) {
        int size = intervals.length;

        // base conditions
        if (size == 0) {
            return new int[][] { new int[] { newInterval[0], newInterval[1] } };
        }
        if (newInterval.length == 0) {
            return intervals;
        }

        System.out.println("Size: " + size);
        int[][] sortedIntervals = new int[size + 1][2]; // SC = O(n + 1)

        if (size == 1) {
            if (intervals[0][0] < newInterval[0]) {
                sortedIntervals[0] = intervals[0];
                sortedIntervals[1] = newInterval;
            } else {
                sortedIntervals[0] = newInterval;
                sortedIntervals[1] = intervals[0];
            }

            for (int[] res : sortedIntervals) {
                System.out.println("Resultant interval range: " + "{" + res[0] + "," + res[1] + "}");
            }

        } else {
            int i = 0;
            for (i = 0; i < size; i++) { // TC = O(n)
                if (intervals[i][0] < newInterval[0]) {
                    sortedIntervals[i] = intervals[i];
                } else {
                    sortedIntervals[i] = newInterval;
                    i++;
                    break;
                }
            }

            for (int[] res : sortedIntervals) { // TC = O(n)
                System.out.println("Resultant interval range: " + "{" + res[0] + "," + res[1] + "}");
            }

            while (i < size + 1) {
                if (sortedIntervals[i - 1] == intervals[i - 1]) {
                    sortedIntervals[i] = newInterval;
                } else {
                    sortedIntervals[i] = intervals[i - 1];
                }
                i++;
            }

            for (int[] res : sortedIntervals) {
                System.out.println("Resultant interval range: " + "{" + res[0] + "," + res[1] + "}");
            }
        }
        int[][] output = mergeIntervalsForSortedArray(sortedIntervals);

        return output;
    }

    private static int[][] mergeIntervalsForSortedArray(int[][] intervals) {
        Stack<int[]> stack = new Stack<>(); // SC = O(n) in worst case and O(1) in best case
        int size = intervals.length;

        // base condition
        if (size <= 1) {
            return intervals;
        }
        if (stack.isEmpty()) {
            stack.add(intervals[0]);
        }

        // intervals = {{1,4}, {3,6}, {7,9}};
        for (int i = 1; i < size; i++) { // TC = O(n-1)
            int[] insertedInterval = stack.peek();
            if (intervals[i][0] <= insertedInterval[1]) {
                stack.pop();
                if (intervals[i][1] > insertedInterval[1]) {
                    insertedInterval[1] = intervals[i][1];
                }
                stack.push(insertedInterval);
            } else if (intervals[i][0] > insertedInterval[1]) {
                stack.push(intervals[i]);
            }
        }

        int stackSize = stack.size();
        int[][] output = new int[stackSize][2]; // Overall: Final TC = O(n) and SC = O(n)
        return stack.toArray(output);
    }

    private static int[][] insert(int[][] intervals, int[] newInterval) {
        int size = intervals.length;

        // base conditions
        if (size == 0) {
            return new int[][] { new int[] { newInterval[0], newInterval[1] } };
        }
        if (newInterval.length == 0) {
            return intervals;
        }

        System.out.println("Size: " + size);
        int[][] latestInterval = new int[size + 1][2]; // SC = O(n + 1)
        for (int i = 0; i < size; i++) { // TC = O(n)
            latestInterval[i] = intervals[i];
        }
        latestInterval[size] = newInterval;

        int[][] mergedInterval = mergeIntervalsForUnsortedArray(latestInterval);
        return mergedInterval;

        // Implement 3 approaches and write TC, SC
        // insert and sort
        // linear search, insert and merge
        // while merging, insert
    }

    private static int[][] mergeIntervalsForUnsortedArray(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); // TC = O(n log n) for sorting elements of an
                                                                       // array
        Stack<int[]> stack = new Stack<>(); // SC = O(n) in worst case and O(1) in best case
        int size = intervals.length;

        // base condition
        if (size <= 1) {
            return intervals;
        }
        if (stack.isEmpty()) {
            stack.add(intervals[0]);
        }

        // int[][] intervals = {{1,4}, {3,6}, {7,9}};
        for (int i = 1; i < size; i++) { // TC = O(n-1)
            int[] insertedInterval = stack.peek();
            if (intervals[i][0] <= insertedInterval[1]) {
                stack.pop();
                if (intervals[i][1] > insertedInterval[1]) {
                    insertedInterval[1] = intervals[i][1];
                }
                stack.push(insertedInterval);
            } else if (intervals[i][0] > insertedInterval[1]) {
                stack.push(intervals[i]);
            }
        }

        int stackSize = stack.size();
        int[][] output = new int[stackSize][2]; // Overall: Final TC = O(n log n) and SC = O(n)
        return stack.toArray(output);
    }
}