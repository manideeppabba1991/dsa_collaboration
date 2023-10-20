public class BubbleSort {
    public static void main(String[] args) {
        int[] unsortedArray = {29, 10, 14, 30, 37, 14, 18};
        sortUsingBubbleSortTech(unsortedArray);
    }
    private static void sortUsingBubbleSortTech(int[] unsortedArray) {

        for(int j = unsortedArray.length - 1; j > 0 ; j--){  // TC: O(n)
            for(int i = 0; i < j; i++) { // TC: O(n)
                if(unsortedArray[i] > unsortedArray[i+1]) { // Total TC = O(n^2)
                    int temp = unsortedArray[i];
                    unsortedArray[i] = unsortedArray[i+1]; // SC = O(1), since only array is used
                    unsortedArray[i+1] = temp;
                }
            }
        }
        System.out.print("Sorted array values are: ");
        for (int i: unsortedArray) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
