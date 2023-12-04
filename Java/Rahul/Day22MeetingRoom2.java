import java.util.*;

public class MeetingRooms2 {
    public static void main(String[] args){

        //int[][] jobs = { { 5, 10}, {15,20},{0,30}} ;
        //int[][] jobs = { { 5, 10}, {15,20},{0,30}} ;[2,11],[6,16],[11,16]
        //{{2,11},{6,16},{11,16}}
        //{{13,15},{1,13}}
        //{{7,10},{2,4}}
        //{{0,30},{5,10},{15,20}}
        int[][] jobs = {{2,15},{36,45},{9,29},{16,23},{4,9}};


        int rooms = meetingRooms(jobs);
        System.out.println(rooms);

    }

    private static int meetingRooms(int[][] intervals) {
        if(intervals.length ==0)
            return 0;
        if(intervals.length ==1)
            return 1;
        Arrays.sort(intervals, Comparator.comparingInt(value -> value[0]));

        Stack<int[]> meetings = new Stack<>();
        meetings.push(intervals[0]);

        for(int i =1; i< intervals.length;i++){
            int[] prev = meetings.pop(); //2,15
            int[] cur = intervals[i]; //9,29
            if(cur[0] < prev[1] ){
                meetings.push(cur);
                meetings.push(prev);
            }else{
                if(cur[1]>prev[1]){
                    meetings.push(cur);
                }else{
                    meetings.push(prev);
                }
            }

            if(meetings.size()>1){
                /*System.out.println("before order");
                for (int[] val :meetings) {
                    System.out.print("{"+val[0]+","+val[1]+"},");
                }
                System.out.println();*/

                Comparator<int[]> customComparator = (arr1, arr2) -> Integer.compare(arr2[1], arr1[1]);
                meetings.sort(customComparator);

                /*System.out.println("after order");
                for (int[] val :meetings) {
                    System.out.print("{"+val[0]+","+val[1]+"},");
                }
                System.out.println();*/
            }
        }
        return meetings.size();
    }

}
