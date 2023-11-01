import java.util.*;

public class SnapshotArray {
    public static int[] actual;

    public static Map<Integer,int[]> snapMap;

    public static int snap;

    public SnapshotArray(int length){
        actual = new int[length];
        Arrays.fill(actual, 0);
    }

    public static void setValue(int idx, int value){
        actual[idx]= value;
    }

    public static int snapshot(){
        if(snapMap == null){
            //snapList = new ArrayList<>();
            snapMap = new HashMap<Integer,int[]>();
            snap =0;
        }else{
            snap++;
        }
        snapMap.put(snap, actual.clone());
        //snapList.add(Arrays.asList((Arrays.stream(actual).boxed().toArray(Integer[]::new))));
        return snap;
    }

    public static int getValue(int idx, int snapshotId1) {
        return snapMap.get(snapshotId1)[snapshotId1];
    }

}
