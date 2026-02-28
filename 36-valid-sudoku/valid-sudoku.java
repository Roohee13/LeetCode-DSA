class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen= new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char current_val=board[i][j];
                if(current_val != '.'){
                    if(!seen.add(current_val +"found in row "+i) ||
                       !seen.add(current_val +" found in coloum "+j)||
                       !seen.add(current_val + " found in sub box " +i/3 +"-"+j/3)){
                        return false;
                       }
                }
            }
        }
        return true;
    }
}