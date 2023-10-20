public class SelectionSort {
    public static void main(String[] args) {
        int[] unsortedArray = {29, 10, 14, 30, 37, 14, 18};
        sortUsingSelectionSortTech(unsortedArray);
    }
    private static void sortUsingSelectionSortTech(int[] unsortedArray) {
        for(int i = 0; i < unsortedArray.length; i++) {
            int min = i;
            for(int j = i+1; j < unsortedArray.length; j++) { //Total TC = O(n^2)
                if(unsortedArray[j] < unsortedArray[min]) { //Total SC = O(1)
                    min = j;
                }
            }
            if(i != min) {
                int temp = unsortedArray[i];
                unsortedArray[i] = unsortedArray[min];
                unsortedArray[min] = temp;
            }
        }
        System.out.print("Sorted array values are: ");
        for (int i: unsortedArray) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
