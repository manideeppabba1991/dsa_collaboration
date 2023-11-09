//https://leetcode.com/problems/missing-number/

class Solution {
    public int missingNumber(int[] nums) {
        int idx = 0;

        while(idx< nums.length){
            if(nums[idx]==idx || nums[idx]>= nums.length ){
                idx++;
                continue;
            }

            //3,0,1
            //0,3,1
            int temp = nums[idx]; //  0 // 1
            nums[idx] = nums[temp];// 3,3,1 //  0,3,3
            nums[temp] = temp;    //0,3,1// 0,1,3

        }

        for(int i=0;i< nums.length; i++){
            if(nums[i] !=i){
                return i;
            }
        }

        return nums.length;
            
    }
}
