import java.util.Arrays;

public class MeetingRoomsRequired {
    public static void main(String[] args) {
        int[][] intervals = { { 2, 15 }, { 36, 45 }, { 9, 29 }, { 16, 23 }, { 4, 9 } };
        int noOfRooms = minMeetingRooms(intervals);
        System.out.println("Total meeting rooms required: " + noOfRooms);
    }

    private static int minMeetingRooms(int[][] intervals) {
        int size = intervals.length;

        //base condition
        if(size <= 1) {
            return size;
        }

        int[] starts = new int[size];
        int[] ends = new int[size];
        for (int i = 0; i < size; i++) { // TC = O(n) and SC = O(n)
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts); //TC = O(n log n )
        Arrays.sort(ends); //TC = O(n log n )
        int rooms = 0;
        int endsItr = 0;
        for (int startsItr = 0; startsItr < starts.length; startsItr++) {
            if (starts[startsItr] < ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }

    // private static int minMeetingRooms(int[][] intervals) {
    // int size = intervals.length;
    // // base condition
    // if (size == 0) {
    // return 0;
    // }
    // if (size == 1) {
    // return 1;
    // }

    // Arrays.sort(intervals, Comparator.comparing(value -> value[0]));
    // Stack<int[]> meetingRoomIntervals = new Stack<>();
    // meetingRoomIntervals.push(intervals[0]);

    // for (int i = 1; i < size; i++) {
    // int[] previous = meetingRoomIntervals.pop(); // 2,15
    // int[] current = intervals[i]; // 4,9
    // if (current[0] < previous[1]) {
    // meetingRoomIntervals.push(previous);
    // meetingRoomIntervals.push(current);
    // } else {
    // if (current[1] > previous[1]) {
    // meetingRoomIntervals.push(current);
    // } else {
    // meetingRoomIntervals.push(previous);
    // }
    // }
    // if (meetingRoomIntervals.size() > 1) {
    // System.out.println("======================================");
    // System.out.println("before order");
    // for (int[] val : meetingRoomIntervals) {
    // System.out.print("{" + val[0] + "," + val[1] + "}");
    // }
    // System.out.println();

    // Comparator<int[]> customComparator = (arr1, arr2) -> Integer.compare(arr2[1],
    // arr1[1]);
    // meetingRoomIntervals.sort(customComparator);

    // System.out.println("after order");
    // for (int[] val : meetingRoomIntervals) {
    // System.out.print("{" + val[0] + "," + val[1] + "}");
    // }
    // System.out.println();
    // }
    // }
    // return meetingRoomIntervals.size();
    // }

    // private static int findMeetingRooms(int[][] intervals) {
    // int size = intervals.length;
    // // base condition
    // if (size == 0) {
    // return 0;
    // }
    // if (size == 1) {
    // return 1;
    // }

    // Arrays.sort(intervals, Comparator.comparing(value -> value[1]));
    // for (int i = 0; i < size; i++) {
    // System.out.println("Contents: {" + intervals[i][0] + "," + intervals[i][1] +
    // "}");
    // }
    // int[] currentInterval = intervals[0];
    // int[] previousInterval = intervals[0];
    // int roomsCount = 1;
    // for (int i = 1; i < size; i++) {
    // if (previousInterval[1] <= intervals[i][0] || currentInterval[0] <
    // intervals[i][0]
    // && currentInterval[1] < intervals[i][1] && currentInterval[1] <=
    // intervals[i][0]) {
    // currentInterval = intervals[i];
    // previousInterval[1] = Math.min(currentInterval[1], previousInterval[1]);
    // } else {
    // roomsCount++;
    // currentInterval[1] = Math.min(currentInterval[1], intervals[i][1]);
    // }
    // }
    // return roomsCount;
    // }

}
