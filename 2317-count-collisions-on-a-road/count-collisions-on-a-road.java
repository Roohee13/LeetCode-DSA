class Solution {
    public int countCollisions(String directions) {
        char[] arr = directions.toCharArray();
        int n = arr.length;
        
        int left = 0, right = n - 1;

        // Ignore leading 'L' cars
        while (left < n && arr[left] == 'L') left++;

        // Ignore trailing 'R' cars
        while (right >= 0 && arr[right] == 'R') right--;

        int collisions = 0;

        // Count all non-'S' cars in the remaining segment
        for (int i = left; i <= right; i++) {
            if (arr[i] != 'S') collisions++;
        }

        return collisions;
    }
}
