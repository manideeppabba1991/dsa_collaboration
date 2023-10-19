//TimeComplexity = O(n^2)
//SpaceComplexity = O(1)
public void bubbleSort() {
        int[] inputArray = new int[] {12,2,25,1,45,123,85};
        for(int j=0; j<inputArray.length;j++) {
            for(int i=0; i<inputArray.length-1; i++){
                int temp;
                if(inputArray[i] > inputArray[i+1]) {
                    temp = inputArray[i];
                    inputArray[i] = inputArray[i+1];
                    inputArray[i+1] = temp;
                }
            }
        }
        System.out.println(inputArray);

    }
