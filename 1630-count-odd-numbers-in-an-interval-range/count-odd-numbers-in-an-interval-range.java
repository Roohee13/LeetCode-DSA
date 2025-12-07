class Solution {
    public int countOdds(int low, int high) {

        // If both low and high are even → number of odds = (high - low) / 2
        // Otherwise → (high - low) / 2 + 1
        
        if (low % 2 == 0 && high % 2 == 0) {
            return (high - low) / 2;
        }
        
        return (high - low) / 2 + 1;
    }
}
