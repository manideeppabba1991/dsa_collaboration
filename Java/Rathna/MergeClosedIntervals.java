https://leetcode.com/problems/merge-intervals/submissions/

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<2)
            return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
        Stack<int[]> mergeStack = new Stack<>();
        mergeStack.push(intervals[0]);

        for(int i=1;i<intervals.length;i++){
            int[] left = mergeStack.pop();
            int[] right = intervals[i];
            int[] cur= new int[2];
            if(right[0]>left[1]){
                mergeStack.push(left);
                mergeStack.push(right);
            }else{
                cur[0] = Math.min(left[0],right[0]);
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
