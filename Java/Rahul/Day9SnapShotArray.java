//https://www.educative.io/courses/grokking-coding-interview-patterns-java/snapshot-array

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SnapshotArray {
    public static int[] actual;
    public static List<List<Integer>> snapList;
    
    public static int snap;

    public SnapshotArray(int length){
        actual = new int[length];
        Arrays.fill(actual, 0);
    }

    public static void setValue(int idx, int value){
        actual[idx]= value;
    }

    public static int snapshot(){
        if(snapList == null){
            snapList = new ArrayList<>();
            snap =0;
        }else{
            snap++;
        }
        snapList.add(Arrays.asList((Arrays.stream(actual).boxed().toArray(Integer[]::new))));
        return snap;
    }

    public static int getValue(int idx, int snapshotId1) {
        return snapList.get(snapshotId1).get(idx);
    }

}
