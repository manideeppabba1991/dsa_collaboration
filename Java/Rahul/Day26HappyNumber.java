class Solution {
    public boolean isHappy(int n) {
        Set<Integer> nums = new HashSet<>();
        while(n!=1 && !nums.contains(n) ){
            nums.add(n);
            int sqr =0;
            while(n != 0){
                int temp = n%10;
                sqr = sqr + (temp*temp);
                n= n/10;
            }
            n= sqr ;
        }
        if(n==1){
            return true;
        }else{
            return false;
        }

    }
}
