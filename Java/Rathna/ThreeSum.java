import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1, 2, 4, 0, 3, 5, -2};
        int target = 4;
        // 5, -1 , 0 ==> 2,3,-1 ==>

        //-2, -1, 0, 2, 3, 4, 5

        // left = a[0] ---> newTarget = target - a[0] ---> newArr = a[1-(length-1)]
        //sort given array asc
        //loop through and get current index and find twoSum of currentIndex + 1 and target = target - curr Index
        //simplify twoSum method and solve it

        // complete this program, follow-up: duplicates
        //Step1: sort // TC = O(nlogn)
        //Ste2: iterate



        Arrays.sort(arr); //Java uses DualPivotQuicksort, TC = O(n log(n))
        List<List<Integer>> opt = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) { //For ThreeSum, TC = O(n^2) and SC = O(1)
            int currValue = arr[i];
            int left = i + 1;
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
