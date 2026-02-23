class Solution {
    public String reverseWords(String s) {
        if(s.equals(null) || s.equals("")){
            return s;
        }
        String res="";
        int i=0;
        while(i<s.length()){
            while(i<s.length() && s.charAt(i)== ' '){
                i++;
            }
            String word="";
            while(i<s.length() && s.charAt(i)!=' '){
               word += s.charAt(i);
               i++;
            }
            if(!word.equals("")){
               res= word+ " " + res;
            }
        }
        if(res.isEmpty()){
            return "";
        }

        return res.substring(0,res.length()-1);
    }
}