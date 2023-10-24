import java.util.Arrays;

public class Day4ClassWork {
    public static void main(String[] args) {
        int[] a = {1,5,4,10};
        int target = 5;
        if(twoSum(a,target)) {
            System.out.println("Sum found");
        } else {
            System.out.println("Not found");
        }

        if(twoSumUsingForLoops(a,target)) {
            System.out.println("Sum found");
        } else {
            System.out.println("Not found");
        }

        int[] reverse = reverseArray(a);
        System.out.print("Reversed array: ");
        for(int i: reverse) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    private static int[] reverseArray(int[] a) {
        int left = 0;
        int right = a.length - 1;
        int temp = 0;
        while(left < right) {
            if(left != right) {
                temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
            left++;
            right--;
        }
        return a;
    }
    private static boolean twoSum(int[] a, int target) {
      a = Arrays.stream(a).sorted().toArray(); //TC = O(nlog(n)) here for sorting and SC = O(1)
      int left = 0;
      int right = a.length - 1;
      while(left < right) {
          if(a[left] + a[right] == target) {
              return true;
          }else if(a[left] + a[right] > target) {
              right = right - 1;
          }else {
              left = left + 1;
          }
      }
        return false;
    }
    private static boolean twoSumUsingForLoops(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) { //TC = O(n^2) and SC = O(1)
                if (a[i] + a[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
