public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 6};
        int searchElement = 2;
        int indexOfSearchElement = searchElementAndFindRightPosition(sortedArray, searchElement);
        System.out.println("Index or possible correct index of search element is: " + indexOfSearchElement);
    }

    private static int searchElementAndFindRightPosition(int[] sortedArray, int searchElement) {
        int left = 0;
        int right = sortedArray.length - 1;

        while(left <= right) {
            int mid = (int) Math.floor((left + right)/2);
            System.out.println("Left = " + left + " Right = " + right + " Mid = " + mid);
            if(searchElement == sortedArray[mid]) {
                System.out.println("Left = " + left + " Right = " + right + " Mid = " + mid);
                return mid;
            } else if(searchElement > sortedArray[mid]) {
                System.out.println("Left = " + left + " Right = " + right + " Mid = " + mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            System.out.println("Left = " + left + " Right = " + right + " Mid = " + mid);
        }
        return left;
/*        if(searchElement < sortedArray[left]) {
            return left;
        } else if(searchElement > sortedArray[left]) {
            return left + 1;
        } else if (searchElement > sortedArray[right]){
            return left + 1;
        } else {
            return left;
        }*/

    }
}
