class Solution {
    public List<String> letterCombinations(String digits) {
       List<String> result= new ArrayList<>();

       if(digits == null || digits.length() ==0){
        return result;
       }

       String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
       backtrack(digits,0,new StringBuilder(),result,map);
       return result;

    }

    public void backtrack(String digits,int index,StringBuilder current,List<String> result,String[] map){
        //base case
        if(index==digits.length()){
            result.add(current.toString());
            return;
        }

        String letter = map[digits.charAt(index) -'0'];

        for(char ch:letter.toCharArray()){
           current.append(ch);
           backtrack(digits,index+1,current,result,map);
           current.deleteCharAt(current.length()-1);
        }
    }
}