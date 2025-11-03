class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set= new HashSet<>();

        for(int num: nums){
            set.add(num);
        }
        int max_squence_length=0;

        for(int num: set){
            int current_num=num;
            int current_sequence_length=1;

            if(!set.contains(current_num-1)){
              while(set.contains(current_num+1)){
                current_num += 1;
                current_sequence_length +=1;
              }
              max_squence_length= Math.max(current_sequence_length,max_squence_length);
            }
        }
        return max_squence_length;
    }
}