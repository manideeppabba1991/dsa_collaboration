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

Boolean SampleProblem(String input) {
        int numberOfOpenRoundParenthesis = 0;
        int numberOfClosedRoundParenthesis = 0;
        int numberOfOpenFlowerParenthesis = 0;
        int numberOfClosedFlowerParenthesis = 0;
        int numberOfOpenSquareParenthesis = 0;
        int numberOfClosedSquareParenthesis = 0;
        boolean outPut=true;
        int counter = 0;
        if(input != null) {
            for(int i=0; i<input.length(); i++) {
                if("(".equalsIgnoreCase(String.valueOf(input.charAt(i)))) {
                    numberOfOpenRoundParenthesis++;
                }
                if(")".equalsIgnoreCase(String.valueOf(input.charAt(i)))) {
                    numberOfClosedRoundParenthesis++;
                }
                if("[".equalsIgnoreCase(String.valueOf(input.charAt(i)))) {
                    numberOfOpenSquareParenthesis++;
                }
                if("]".equalsIgnoreCase(String.valueOf(input.charAt(i)))) {
                    numberOfClosedSquareParenthesis++;
                }
                if("{".equalsIgnoreCase(String.valueOf(input.charAt(i)))) {
                    numberOfOpenFlowerParenthesis++;
                }
                if("}".equalsIgnoreCase(String.valueOf(input.charAt(i)))) {
                    numberOfClosedFlowerParenthesis++;
                }
                counter++;
            }
            if(numberOfOpenRoundParenthesis!=numberOfClosedRoundParenthesis
                    || numberOfOpenFlowerParenthesis!=numberOfClosedFlowerParenthesis
                    || numberOfOpenSquareParenthesis!=numberOfClosedSquareParenthesis) {
                outPut=false;
            }
        }
        return outPut;
    }


void SampleProblem(String input) {
        boolean result = true;
        List<Boolean> booleanOutput = new ArrayList<>();
        if(input != null) {
           booleanOutput =  inputString(input, booleanOutput);
           result = !booleanOutput.contains(false);
           log.info("result" + result);
        }
    }

    private List<Boolean> inputString(String input, List<Boolean> booleanList) {
            for(int i=0; i<input.length()-1; i++) {
                String nextChar = String.valueOf(input.charAt(i + 1));
                if(("(".equalsIgnoreCase(String.valueOf(input.charAt(i))) && ")".equalsIgnoreCase(nextChar))
                        || ("[".equalsIgnoreCase(String.valueOf(input.charAt(i))) && "]".equalsIgnoreCase(nextChar))
                        || ("{".equalsIgnoreCase(String.valueOf(input.charAt(i))) && "}".equalsIgnoreCase(nextChar))) {
                    input = input.substring(0, i) + input.substring(i + 2);
                    booleanList.add(true);
                } else {
                    booleanList.add(false);
                }
                return inputString(input, booleanList);
            }
        if(input.length() == 1) {
            booleanList.add(false);
        }
        return booleanList;
    }
