import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumWithDuplicateElementsNonRepeatOutput {
    public static void main(String[] args) {
        int[] arr = {2, -2, -1, 0, 2, 3, 3, 5};
        int target = 3;
        // Expected output: 5, -1 , 0 ==> 2, 3, -1 ==> 2, -2, 4

        //sort given array asc
        //loop through and get current index and find twoSum of currentIndex + 1 and newTarget = target - curr Index
        //simplify twoSum method and solve it

        // complete this program, follow-up: duplicates

        Arrays.sort(arr); //Java uses DualPivotQuicksort, TC = O(n log(n))
        List<List<Integer>> opt = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) { //For ThreeSum, TC = O(n^2) and SC = O(1)
            int currValue = arr[i];
            int left = i + 1;

            if (i != 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            opt.addAll(twoSum(arr, currValue, left, target - currValue)); //TC = O(n) and SC = O(1)
        }

        System.out.println(opt);
    }

    private static List<List<Integer>> twoSum(int[] arr, int curr, int left, int newTarget) { //TC = O(n) and SC = O(1)
        int right = arr.length - 1;
        List<List<Integer>> opt = new ArrayList<>();
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == newTarget) {
                List<Integer> result = new ArrayList<>();
                result.add(curr);
                result.add(arr[left]);
                result.add(arr[right]);
                opt.add(result);

                while (left < right && arr[left] == arr[left + 1])
                    left++;
                while (left < right && arr[right] == arr[right - 1])
                    right--;

                left++;
                right--;
            } else if (sum < newTarget) {
                left++;
            } else {
                right--;
            }
        }
        return opt;
    }
}
