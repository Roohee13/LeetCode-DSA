class Solution {
    public int jump(int[] nums) {
        int current=0,jump=0,farthest=0;
        for(int i=0;i<nums.length-1;i++){
            farthest=Math.max(farthest,nums[i]+i);
            if(i==current){
              jump++;
              current=farthest;
            }
        }
        return jump;
    }
}