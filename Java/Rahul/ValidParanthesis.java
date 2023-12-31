/*
  Problem - Valid Parentheses
  
  Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
  
  An input string is valid if:
  
    - Open brackets must be closed by the same type of brackets.
    - Open brackets must be closed in the correct order.
    - Every close bracket has a corresponding open bracket of the same type.
     
  
  - Example 1:
      Input: s = "()"
      Output: true
  
  - Example 2:
      Input: s = "()[]{}"
      Output: true
      
  - Example 3:
      Input: s = "(]"
      Output: false
       
  
  **Constraints**:
  
  1 <= s.length <= 104
  s consists of parentheses only '()[]{}'.
*/

//first checking if a string is valid or not


 public class ManiTest {
  public static void main(String[] args) {
  
    String x = "()[]{}";
    
    if(isValidStr(x)){
    	System.out.println("Valid");
    }else{
    	System.out.println("InValid");
    }
	
  }
  
  public static boolean isValidStr(String x){
 
	int len = x.length();
	if(!x.matches("[()\\[\\]{}]+") || (x.length()<1 || x.length()>104) || x.length() %2 	!= 0){
    	return false;
	}
    String inChar = "[{(";
	StringBuffer inptSide = new StringBuffer((len/2)+1); 
	for (int i=0 ;i< len ;i++){
    	char right = x.charAt(i);
    	if(inChar.contains(String.valueOf(right))){
            inptSide.append(right);
        }
        else{
        	if(inptSide.length()<1){
            	System.out.println("InValid");
                return false;
            }
            char lft = inptSide.charAt(inptSide.length()-1);

            if((right == ')' && lft == '(') || (right == ']' && lft == '[') || (right == '}' && lft == '{')){
                inptSide = inptSide.deleteCharAt(inptSide.length()-1);
            }
            	
        }
	}
    if(inptSide.length()>0){
    	return false;
    }else{
    	return true;
    }
  }
}
