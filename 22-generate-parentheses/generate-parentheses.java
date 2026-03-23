class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result= new ArrayList<>();
        backtrack(result,0,0,n,new StringBuilder());
        return result;
    }

    private void backtrack(List<String> result, int open,int close,int n,StringBuilder current){
        //base case
        if(current.length()== 2*n){
            result.add(current.toString());
            return;
        }

        // for open
        if(open<n){
            current.append('(');
            backtrack(result,open+1,close,n,current);
            current.deleteCharAt(current.length()-1);
        }

        //for close
        if(close<open){
            current.append(')');
            backtrack(result,open,close+1,n,current);
            current.deleteCharAt(current.length()-1);
        }
        
    }
}