import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SnapshotArray {
    private static int snapId;
    private int[] snapArray;
    private Map<Integer, int[]> myHashMap;

    // Constructor
    public SnapshotArray(int length) {
        snapArray = new int[length];
        Arrays.fill(snapArray, 0);
        snapId = 0;
        myHashMap = new HashMap<>();
    }

    // Function setValue sets the value at a given index idx to val.
    public void setValue(int idx, int state) {
        snapArray[idx] = state;
    }

    // This function takes no parameters and returns the snapid.
    // snapid is the number of times that the snapshot() function was called minus 1.
    public int snapshot() {
        myHashMap.put(snapId, snapArray);
        snapId++;
        return snapId - 1;
    }

    // Function getValue returns the value at the index idx with the given snapid.
    public int getValue(int idx, int snapshotId1) {
        int[] resultArray = myHashMap.get(snapshotId1);
        return resultArray[idx];
    }
}
