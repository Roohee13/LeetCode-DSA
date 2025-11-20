import java.util.*;

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) 
                return b[0] - a[0];
            return a[1] - b[1];
        });
        
        int p1 = -1, p2 = -1;  // last two chosen points
        int count = 0;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            boolean hasP1 = p1 >= start && p1 <= end;
            boolean hasP2 = p2 >= start && p2 <= end;

            if (hasP1 && hasP2) {
                continue;
            }

            if (hasP1 || hasP2) {
                // Add one more point
                count++;
                int newPoint = end;

                // set p2 = old p1 or p2 whichever inside
                p2 = p1 >= start ? p1 : p2;
                p1 = newPoint;
            } 
            else {
                // Add two points: end-1 and end
                count += 2;
                p2 = end - 1;
                p1 = end;
            }
        }

        return count;
    }
}
