
/**
     * TimeComplexity = O(n^2)
     * SpaceComplexity = O(1)
     */
class SelectionSort {
    public static void main(String[] args) {
        int[] inputArray = new int[]{2,5,12,1,3};
        sort(inputArray);
    }
    
    public int[] sort(int[] inputArray) {
        int minValue = 0;
        int minValueIndex = 0;
        for(int i=0; i<=inputArray.length-1;i++) {
            minValueIndex = i;
            minValue = inputArray[i];
            for(int j=i+1;j<inputArray.length;j++) {
                if (inputArray[j] < minValue) {
                    minValue = inputArray[j];
                    minValueIndex = j;
                }
            }
            inputArray[minValueIndex] = inputArray[i];
            inputArray[i] = minValue;
        }
        System.out.println("SortedArray " + inputArray);
        return inputArray;
    }
}
