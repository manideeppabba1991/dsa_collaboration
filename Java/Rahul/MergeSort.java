//space = o(n)
//time = nlogn

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args){
        int[] in = new int[]{23,4,56,21,3,8,32};
        int[] out = mergeSort(in);
        for(int i:out)
            System.out.println(i);
    }

    private static int[] mergeSort(int[] in) {
        if(in.length == 1)// this is exit condition of recurrsion , we return array if that is a single element
            return in;

        int mid = in.length/2; // getting the mid of array, to make arrays into half

        int[] left = mergeSort(Arrays.copyOfRange(in,0,mid)); // first half of the array, here mid is used as length
        int[] right = mergeSort(Arrays.copyOfRange(in,mid,in.length));//second half of the array, here mid is used as start of array

        return mergeTwoLists(left,right);// merging two halfs and returning that;

    }

    private static int[] mergeTwoLists(int[] left, int[] right) {
        int l = 0;
        int r =0;
        int counter =0;
        int[] out = new int[left.length+right.length]; // creating new array of length of two half arrays

        while(l < left.length && r < right.length){
            if(left[l] < right[r]){ // checking if left is less than right and adding left
                out[counter] = left[l];
                l++;
                counter++;
            }else{ // if left is not lss than right adding right
                out[counter] = right[r];
                r++;
                counter++;
            }
        }

        while(l < left.length ){ // is left have more values adding remaining left
            out[counter] = left[l];
            l++;
            counter++;
        }
        while(r < right.length){ // if right have more values adding remaining right
            out[counter] = right[r];
            r++;
            counter++;
        }

        return out;
    }
}
