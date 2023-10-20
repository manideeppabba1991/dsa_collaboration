public class SortUsingBinarySearch {
    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5};
        int searchElement = 4;
        if(sortUsingBinarySearchTech(sortedArray,searchElement)) {
            System.out.println("Value exists");
        } else {
            System.out.println("Value doesn't exist");
        }
    }

    private static boolean sortUsingBinarySearchTech(int[] sortedArray, int searchElement) {
        int left = 0;
        int right = sortedArray.length - 1;
        while(left < right) {
            int mid = (int) Math.floor((left + right)/2); //TC = O(log n)
            if(searchElement == sortedArray[mid]) {  // SC = O(1)
                return true;
            }else if(searchElement > sortedArray[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
