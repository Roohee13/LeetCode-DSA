class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows= matrix.length;
        int cols= matrix[0].length;

        int start= 0;
        int end= rows*cols -1;

        while(start<=end){
            int mid= start+(end-start)/2;
            int mid_element= matrix[mid/cols][mid%cols];

            if(mid_element == target){
                return true;

            }else if(target > mid_element){
                start= mid+1;

            }else if(target < mid_element){
                end=mid-1;
            }
        }
        return false;

    }
}