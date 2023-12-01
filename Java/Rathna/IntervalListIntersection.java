import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersection {
    public static void main(String[] args) {
        int[][] first = {{1,4}, {5,6}, {7,9}};
        int[][] second = {{3,5}, {6,7}, {8,9}};

        int[][] output = intersectIntervals(first, second);
        for(int[] out : output) {
            System.out.println("Intersected Intervals - Resultant interval range: " + "{" + out[0] + "," + out[1] + "}");
        }
    }

    private static int[][] intersectIntervals(int[][] first, int[][] second) {
        int ptrFirst = 0;
        int ptrSecond = 0;
        int sizeFirst = first.length;
        int sizeSecond = second.length;

        List<int[]> result = new ArrayList<>();

        while(ptrFirst < sizeFirst && ptrSecond < sizeSecond) {
            int firstStart = first[ptrFirst][0];
            int firstEnd = first[ptrFirst][1];

            int secondStart = second[ptrSecond][0];
            int secondEnd = second[ptrSecond][1];

            if(firstStart <= secondEnd && secondStart <= firstEnd) {
                int intersectedStart = Math.max(firstStart, secondStart);
                int intersectedEnd = Math.min(firstEnd, secondEnd);
                int[] intersectedInterval = {intersectedStart, intersectedEnd};
                result.add(intersectedInterval);
            }

            if(secondEnd > firstEnd) {
                ptrFirst++;
            } else {
                ptrSecond++;
            }
        }

        return result.toArray(new int[result.size()][2]);
    }
    
}
