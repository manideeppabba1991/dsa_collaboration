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

 public static void main(String[] args) {
  
    String x = "()";
	int len = x.length();
	if(!x.matches("[()\\[\\]{}]+") || (x.length()<1 || x.length()>104) || x.length() %2 	!= 0){
    	System.out.println("InValid");
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
            }
            char lft = inptSide.charAt(inptSide.length()-1);
            System.out.println("right "+right);
            System.out.println("left "+lft);

            if((right == ')' && lft == '(') || (right == ']' && lft == '[') || (right == '}' && lft == '{')){
				System.out.println(inptSide.charAt(inptSide.length()-1));
                //inptSide = inptSide.deleteCharAt(inptSide.length()-1);
            }
            	
        	System.out.println(inptSide.charAt(inptSide.length()-1));
        }
	}
    if(inptSide.length()>0){
    	System.out.println("InValid");
    }else{
    	System.out.println("Valid");
    }
  }


