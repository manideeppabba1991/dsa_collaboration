public class MergeSortedLists {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,8,9,10};
        int[] b = {1,4,5,6};
        int[] c = new int[a.length + b.length];
        c = mergeTwoSortedArrays(a, b, c);
        for(int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
        System.out.println();
    }

    private static int[] mergeTwoSortedArrays(int[] a, int[] b, int[] c) {
        int left = 0;
        int right = 0;
        int counter = 0;
        while(left < a.length && right < b.length) {
            //System.out.println("1st while - Left = " + left + " Right = " + right + " counter = " + counter);
            if(a[left] < b[right]) {
                c[counter++] = a[left++];
                //System.out.println("1st while IF - Left = " + left + " Right = " + right + " counter = " + counter);
            }
            else {
                c[counter++] = b[right++];
                //System.out.println("1st while ELSE - Left = " + left + " Right = " + right + " counter = " + counter);
            }
        }
        while(left < a.length) {
            //System.out.println("2nd while - Left = " + left + " Right = " + right + " counter = " + counter);
            c[counter++] = a[left++];
            //System.out.println("2nd while - Left = " + left + " Right = " + right + " counter = " + counter);
        }
        while(right < b.length) {
            //System.out.println("3rd while - Left = " + left + " Right = " + right + " counter = " + counter);
            c[counter++] = b[right++];
            //System.out.println("3rd while - Left = " + left + " Right = " + right + " counter = " + counter);
        }

        return c;
    }
}
