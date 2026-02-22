class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank=0,currentTank=0,startIndex=0;
        
        for(int i=0;i<gas.length;i++){
            int diff= gas[i]-cost[i];
            totalTank = totalTank + diff;
            currentTank = currentTank + diff;
            
            if(currentTank<0){
                startIndex=i+1;
                currentTank=0;
            }
        }

        return totalTank>=0 ? startIndex : -1;
    }
}