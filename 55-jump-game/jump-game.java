class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        int lastIndex=nums.length-1;
        int maxReach=nums[0];
        for(int i=1;i<=maxReach;i++){
            if(maxReach>=lastIndex){
                return true;
            }else{
                maxReach=Math.max(maxReach,nums[i]+i);
            }
        }
        return false;
    }
}