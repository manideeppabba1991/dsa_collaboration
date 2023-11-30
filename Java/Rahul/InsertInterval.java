//https://leetcode.com/problems/insert-interval/submissions/
//added total 3 ways
// adding element and sorting-- one nlogn
// adding elemen with linear search -- 2n
// adding while merging --n

import java.util.*;

public class MergeIntervalElement {

    public static void main(String[] args){

        //[[1,2],[3,5],[6,7],[8,10],[12,16]]
        //[4,8]
        int[][] interval = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newinterval = new int[]{4,8};

        int[][] merger =insertThird(interval,newinterval );

        for (int[] t : merger) {
            System.out.println();
            for(int i=0;i<t.length;i++){
                System.out.print(t[i] +",");
            }
        }


    }
    public static int[][] insertFirst(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        int[][] addedIntervals = new int[len+1][2];
        System.arraycopy(intervals, 0, addedIntervals, 0, intervals.length);
        addedIntervals[len] = newInterval;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        if(addedIntervals.length<2)
            return addedIntervals;

        Arrays.sort(addedIntervals, (a, b) -> Integer.compare(a[0],b[0]));
        Stack<int[]> mergeStack = new Stack<>();
        mergeStack.push(addedIntervals[0]);

        for(int i=1;i<addedIntervals.length;i++){
            int[] left = mergeStack.pop();
            int[] right = addedIntervals[i];
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

    public static int[][] insertSecond(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        int[][] addedIntervals = new int[len+1][2];
        if(len ==0){
            addedIntervals[0] = newInterval;
            return addedIntervals;
        }
        int counter =0;
        boolean inserted = false;
        for(int i=0;i<len;i++){
            if(!inserted && newInterval[0]<intervals[i][0]){
                addedIntervals[counter] = newInterval;
                counter++;
                inserted = true;
            }
            addedIntervals[counter] = intervals[i];
            counter++;
        }
        if(!inserted){
            addedIntervals[counter] = newInterval;
        }
        if(addedIntervals.length<2)
            return addedIntervals;

        Stack<int[]> mergeStack = new Stack<>();
        mergeStack.push(addedIntervals[0]);

        for(int i=1;i<addedIntervals.length;i++){
            int[] left = mergeStack.pop();
            int[] right = addedIntervals[i];
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

    public static int[][] insertThird(int[][] intervals, int[] newInterval) {

        if(intervals.length < 1){
            int[][] opt = new int[1][2];
            opt[0] = newInterval;
            return opt;
        }

        //[[1,2],[3,5],[6,7],[8,10],[12,16]] -- 4,8]
        //Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));

        Stack<int[]> mergeStack = new Stack<>();
        mergeStack.add(intervals[0]);
        boolean newInDone = false;
        //intervals = [[2,3],[6,9]], newInterval = [1,5]  ,6,7
        for(int i =1;i<intervals.length;i++){


            int[] left = mergeStack.pop();
            int[] right = intervals[i];

            if(!newInDone && newInterval[0]<= left[1]){
                if(newInterval[1]<left[0]){
                    mergeStack.push(newInterval);
                    newInDone = true;
                }else{
                    left[0] = Math.min(left[0],newInterval[0]);
                    left[1] = Math.max(left[1],newInterval[1]);
                    newInDone = true;
                }
            }

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

        if(!newInDone){
            int[] left = mergeStack.pop();  //1,5 -- 0,3

            if(!newInDone && newInterval[0]<= left[1]){
                if(newInterval[1]<left[0]){
                    mergeStack.push(newInterval);
                    mergeStack.push(left);
                    newInDone = true;
                }else{
                    left[0] = Math.min(left[0],newInterval[0]);
                    left[1] = Math.max(left[1],newInterval[1]);
                    mergeStack.push(left);
                    newInDone = true;
                }
            }else{
                mergeStack.push(left);
                mergeStack.push(newInterval);
            }

        }
        int stackSize = mergeStack.size();
        int[][] output = new int[stackSize][2]; //Overall: Final TC = O(n log n) and SC = O(n)
        return mergeStack.toArray(output);
    }
}
