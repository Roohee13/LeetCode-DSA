class Solution {
    public int removeDuplicates(int[] nums) {
        int count=0;
        for(int curr=0;curr<nums.length-1;curr++){
            int next=curr+1;
            if(nums[curr]!= nums[next]){
                count++;
                nums[count]=nums[next];
            }
        }
        return count+1;
    }
}