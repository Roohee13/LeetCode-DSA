class Solution {
    public boolean isPalindrome(String s) {
        String fixedStr="";
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            if(Character.isDigit(ch) || Character.isLetter(ch)){
                fixedStr += ch;
            }
        }

        fixedStr= fixedStr.toLowerCase();

        int left =0;
        int right= fixedStr.length()-1;
        while(left<=right){
            if(fixedStr.charAt(left)!= fixedStr.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}