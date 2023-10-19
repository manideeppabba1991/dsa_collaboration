 /**
     * TimeComplexity - O(n^2)
     * SpaceComplexity - O(1)
     */
    public void insertionSort() {
        int[] inputArray = new int[] {12,5,2,47,54};
        int tempValue=0;
        for(int i=1; i<inputArray.length; i++) {
            tempValue = inputArray[i];
            int j = i-1;
            while(j>=0 && tempValue<inputArray[j]) {
                inputArray[j+1] = inputArray[j];
                j--;
            }
            inputArray[j+1] = tempValue;
        }
        System.out.println("SortedArray" + inputArray);
    }
