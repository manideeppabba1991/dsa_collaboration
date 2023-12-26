https://leetcode.com/problems/backspace-string-compare/submissions/
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int left = s.length();
        int right = t.length();

        int shiftLeft =0;
        int shiftRight =0;

        while (left>0 && right>0) {
            char leftChar = s.charAt(left-1);
            char rightChar = t.charAt(right-1);
            if(leftChar == '#' || rightChar == '#'){
                if(leftChar == '#'){
                    left--;
                    shiftLeft++;
                }
                if(rightChar == '#'){
                    right--;
                    shiftRight++;
                }

            }else if ( shiftLeft>0 || shiftRight>0) {
                if( shiftRight>0){
                    right--;
                    shiftRight--;
                }
                if(shiftLeft>0){
                    left--;
                    shiftLeft--;
                }
            }else if(rightChar != leftChar){
                return false;
            }else if(leftChar == rightChar){
                left--;
                right--;
            }
        }

        int leftRem =0;
        while(left>0){
            char leftChar = s.charAt(left-1);
            if(leftChar == '#' ){
                left--;
                shiftLeft++;
            }else if(shiftLeft>0){
                left--;
                shiftLeft--;
            }else {
                leftRem++;
                left--;
            }
        }
        int rightRem =0;
        while(right>0){
            char rightChar = t.charAt(right-1);
            if(rightChar == '#' ){
                right--;
                shiftRight++;
            }else if(shiftRight>0){
                right--;
                shiftRight--;
            }else {
                rightRem++;
                right--;
            }
        }

        if(rightRem ==0 && leftRem ==0)
            return true;

        if(leftRem != rightRem)
            return false;

        return true;
    }
}
