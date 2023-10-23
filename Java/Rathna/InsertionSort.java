public class InsertionSort {
    public static void main(String[] args) {
        int[] unsortedArray = {29, 10, 14, 30, 37, 14, 18};
        sortUsingInsertionSortTech(unsortedArray);
    }
    private static void sortUsingInsertionSortTech(int[] unsortedArray) {
        for(int j = 1; j < unsortedArray.length ; j++) { //Total TC = O(n^2)
            for(int i = j; i > 0; i--){ //Total SC = O(1)
                if(unsortedArray[i] < unsortedArray[i-1])
                {
                    int temp = unsortedArray[i-1];
                    unsortedArray[i-1] = unsortedArray[i];
                    unsortedArray[i] = temp;
                }
                else {
                    break;
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
