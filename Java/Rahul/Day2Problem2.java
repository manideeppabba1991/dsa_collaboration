class Solution {
    public int shipWithinDays(int[] nums, int target) {
        int left = 0;
        int right = 0;

        for(int i: nums){
            right = right+i;
            if(i>left){
                left = i;
            }
        }
        int res = right;
        
        
        while(left <= right){
            int mid = (int) Math.floor((left+right)/2);
            if(correctCapacity(nums,target,mid)){
                res = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
         return res;
    }
    public static boolean correctCapacity(int[] nums, int target,int capacity){
        int daysNeed = 1;
        int curWeight= 0;
        for(int i: nums){
            if(i+curWeight > capacity){
                daysNeed++;
                curWeight =0;
            }
            curWeight = curWeight + i;
        }

        return daysNeed <= target;
    }
}
