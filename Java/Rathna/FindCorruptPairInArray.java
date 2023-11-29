import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCorruptPairInArray {
    public static void main(String[] args) {
        int[] arr = {4, 3, 4, 5, 1};
        List<Integer> list = findCorruptPair(arr);
        System.out.println("Missing and duplicate corrupt pair in the given array is: " + list);
    }

    private static List<Integer> findCorruptPair(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != arr[arr[i] - 1]) { // TC = O(n) and SC = O(1)
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                return new ArrayList<>(Arrays.asList(j + 1, arr[j]));
            }
        }
        return new ArrayList<>();
    }
}
