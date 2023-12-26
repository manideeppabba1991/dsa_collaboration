//https://leetcode.com/problems/backspace-string-compare/submissions/
//TC = O(n) , space =O(n) 2n
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>(); 
        Stack<Character> t1 = new Stack<>(); 
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) == '#' ){
                if(!s1.isEmpty()){
                    s1.pop();
                }                
            }else{
                s1.add(s.charAt(i));
            }
        }
        
        for(int i =0;i<t.length();i++){
            if(t.charAt(i) == '#' ){
                if(!t1.isEmpty()){
                    t1.pop();
                }                
            }else{
                t1.add(t.charAt(i));
            }
        }

        return s1.equals(t1);
    }
}
