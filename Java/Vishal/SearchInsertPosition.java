class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length;
        int result;
        if(left == right) {
            result = left;
            return result;
        }
        while(left<=right) {
            int mid = Math.floor((left+right)/2);
            if(nums[mid] == target) {
                result=mid;
                return result;
            } else if(nums[mid] < target) {
                left=mid+1;
            } 
            else {
                right = mid-1;
            }
        }
        result = right+1;
        return result;
    }
}

//TimeComplexity=O(logn) SpaceComplexity =  O(1)

