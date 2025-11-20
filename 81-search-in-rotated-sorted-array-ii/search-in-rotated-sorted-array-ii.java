class Solution {
    public boolean search(int[] nums, int target) {
          int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Found the target
            if (nums[mid] == target) {
                return true;
            }
            
            // If left, mid, and right are equal, we can't decide which part is sorted
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }
            // Left part is sorted
            else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;  // target in left sorted part
                } else {
                    left = mid + 1;   // target not in left side
                }
            }
            // Right part is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;   // target in right sorted part
                } else {
                    right = mid - 1;  // target not in right side
                }
            }
        }
        
        return false;
    }
}