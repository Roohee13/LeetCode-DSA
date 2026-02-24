class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s==null || s.equals("")){
            return true;
        }

        int index=0;
        for(int i=0;i<t.length();i++){
            if(s.charAt(index)==t.charAt(i)){
                index++;
            }
            if(s.length()==index){
                return true;
            }
        }
        return false;
    }
}