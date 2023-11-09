//https://leetcode.com/problems/find-the-duplicate-number/submissions/


public class CyclicSort {

    public static void main(String[] args){
        int[] in = {2,1,4,3,3,5};

        for(int i: in){
            System.out.print(" "+i);
        }
        findDuplicate(in);
        System.out.println(" ");
        for(int i: in){
            System.out.print(" "+i);
        }
    }

    private static void findDuplicate(int[] nums) {
        int index = 0; //
        while(index<nums.length){


            if(nums[index] == index+1 ){
                index++;
                continue;
            }
            int temp = nums[index]; //1,2,3,4,1,5 -- temp =1

            if(nums[temp-1] == temp){
                System.out.println("dup "+ temp);
                break;
            }

            nums[index] = nums[temp-1];
            nums[temp-1]= temp;
        }
    }
}
