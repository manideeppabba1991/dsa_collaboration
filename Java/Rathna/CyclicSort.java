public class CyclicSort {
    public static void main(String[] args) {
        // works for 1 to n -- similar Q in Walmart
        int[] arr = {2,3,4,1,5};
        sortArray(arr);

        //Find the duplicate number from 1 to n
        int[] dupArr = {2,4,4,1,5};
        System.out.println("Duplicate: " + findDuplicate(dupArr));

        //find the missing number from 0 to n
        int[] missingArr = {1,0,3};
        System.out.println("Missing Numbers: " + missingNumber(missingArr));
    }

    private static int missingNumber(int[] arr1) {
        int i = 0;
        int missing = 0;
        while(i < arr1.length) {
            if(arr1[i] == i || arr1[i] >= arr1.length) {
                i++;
            } else {
                int temp = arr1[i]; // temp = 0
                arr1[i] = arr1[temp]; //arr[0] = arr[2] ==> 1,0,1
                arr1[temp] = temp; //arr[2] = 3 ==> 1,0,3
            }
        }
        System.out.println("Sorted Array: ");
        for(int j: arr1) {
            System.out.print(j + " ");
        }
        System.out.println();
        for(int k = 0; k < arr1.length; k++) {
            if(arr1[k] != k) {
                missing = k;
                System.out.println("missing: " + missing);
                return missing;
            }
        }
        return missing;
    }

    private static void sortArray(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            if(arr[i] == i + 1) {
                i++;
            } else {
                int temp = arr[i]; // temp = 1
                arr[i] = arr[temp - 1]; //arr[4] = arr[0] ==> 1,2,3,4,1
                arr[temp - 1] = temp; //arr[0] = 1 ==> 1,2,3,4,1
            }
        }
        System.out.println("Sorted Array: ");
        for(int j: arr) {
            System.out.print(j + " ");
        }
    }

    private static int findDuplicate(int[] arr) {
        int i = 0;
        int duplicate = 0;
        while(i < arr.length) {
            if(arr[i] == i + 1) {
                i++;
            } else {
                int temp = arr[i]; // temp = 1
                if(arr[temp - 1] == temp) {
                    duplicate =  temp;
                    System.out.println();
                    System.out.println("Dup: " + duplicate);
                    return duplicate;
                }
                arr[i] = arr[temp - 1]; //arr[4] = arr[0] ==> 1,2,3,4,1
                arr[temp - 1] = temp; //arr[0] = 1 ==> 1,2,3,4,1
            }
        }
        return duplicate;
    }
}
