class Solution {
    public List<Integer> majorityElement(int[] nums) {
         Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }

        int majority= nums.length/3;
        List<Integer> result= new ArrayList<>();

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > majority){
                result.add(entry.getKey());

            }
        }

        return result;
    }
}