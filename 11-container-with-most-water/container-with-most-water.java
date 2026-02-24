class Solution {
    public int maxArea(int[] height) {
        int maxArea=0,currentArea=0;
        int left=0;
        int right=height.length-1;
        while(left<right){
            currentArea=(int)(Math.min(height[left],height[right]))*(right-left);
            maxArea=Math.max(currentArea,maxArea);
            if(height[left]<= height[right]){
                left++;
            }else if(height[right]<height[left])
            {
                right--;
            }
        }
        return maxArea;
    }
}