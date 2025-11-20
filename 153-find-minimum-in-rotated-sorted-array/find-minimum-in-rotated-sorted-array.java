class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than the rightmost element,
            // the minimum lies in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Minimum lies in the left half (including mid)
                right = mid;
            }
        }

        // After the loop, left == right (minimum element)
        return nums[left];
    }
}
