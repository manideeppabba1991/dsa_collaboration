import java.util.*;

class Solution {
    public static int[][] mergeIntervals(int[][] intervals) {
        // Replace this placeholder return statement with your code
        if(intervals.length<2)
            return intervals;

        Stack<int[]> mergeStack = new Stack<>();
        mergeStack.push(intervals[0]);

        List<int[]> merger = new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            int[] left = mergeStack.pop();
            int[] right = intervals[i];
            int[] cur= new int[2];
            if(right[0]>left[1]){
                mergeStack.push(left);
                mergeStack.push(right);
            }else{
                cur[0] = left[0];
                cur[1] = Math.max(left[1],right[1]);
                mergeStack.push(cur);
            }
        }

       int[][] out = new int[mergeStack.size()][2];

        for (int i=0;i<mergeStack.size();i++) {
            out[i]= mergeStack.get(i);
        }
        return out;
    }
}
