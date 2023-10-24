import java.util.Arrays;

public class ImplementMergeSort {
    public static void main(String[] args) {
        int[] arr = {5,15,2,25,1,30};
        int[] mergeSortArr = mergeSort(arr);
        System.out.print("");
        for(int i : mergeSortArr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] mergeSort(int[] arr) {
        if(arr.length == 1) { //Base condition for recursion
            return arr;
        }
        //Follow Divide and Conquer procedure
        //Divide the array and handle each part recursively until we reach base condition on each side
        int mid = arr.length/2;
        System.out.println("Value of mid: " + mid);
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid)); //Based on the mid-value, we create a new array of size mid (First call, mid = 3 then 1, 1, 1 for recursive calls)
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length)); //Based on the mid-value, we create a new array of size mid (First call, mid = 3 then 1, 1, 1 for recursive calls)
        //Now we have individually arrays, which we will sort using two pointers below
        System.out.print("Left Side: ");
        for(int i : left) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("Right Side: ");
        for(int i : right) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] sortedArr = mergeTwoArrays(left, right);
        return sortedArr;
    }

    private static int[] mergeTwoArrays(int[] left, int[] right) {
        int lef = 0;
        int rig = 0;
        int count = 0;
        int[] result = new int[left.length + right.length];

        while(lef < left.length &&  rig < right.length) { //TC = O(nlog(n)) and SC = O(1)
            if(left[lef] < right[rig]) { // Compare left and right arrays and lesser values goes into result array
                result[count++] = left[lef++];
            } else {
                result[count++] = right[rig++];
            }
        }
        while(lef < left.length) { // If any additional elements in left array gets directly added to result array
            result[count++] = left[lef++];
        }
        while(rig < right.length) { // If any additional elements in right array gets directly added to result array
            result[count++] = right[rig++];
        }
        return result;
    }
}
