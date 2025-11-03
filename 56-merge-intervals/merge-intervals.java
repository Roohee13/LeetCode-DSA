class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> output = new ArrayList<>();
        int[] current=intervals[0];
        output.add(current);

        for(int[] interval: intervals){
            int currentEnd=current[1];
            int nextStart=interval[0];
            int nextEnd=interval[1];

            if(currentEnd>= nextStart){
                current[1]=Math.max(currentEnd,nextEnd);
            }else{
                current = interval;
                output.add(interval);

            }
        }

        return output.toArray(new int [output.size()][]);
    }
}