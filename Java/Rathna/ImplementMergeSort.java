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
        if(arr.length == 1) { //Based condition for recursion
            return arr;
        }
        //Follow Divide and Conquer procedure
        //Divide the array and handle each part individually
        int mid = arr.length/2;
        System.out.println("Value of mid: " + mid);
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        int[] sortedArr = mergeTwoArrays(left, right);
        return sortedArr;
    }

    private static int[] mergeTwoArrays(int[] left, int[] right) {
        int lef = 0;
        int rig = 0;
        int count = 0;
        int[] result = new int[left.length + right.length];

        while(lef < left.length &&  rig < right.length) { //TC = O(nlog(n)) and SC = O(1)
            if(left[lef] < right[rig]) {
                result[count++] = left[lef++];
            } else {
                result[count++] = right[rig++];
            }
        }
        while(lef < left.length) {
            result[count++] = left[lef++];
        }
        while(rig < right.length) {
            result[count++] = right[rig++];
        }
        return result;
    }
}
