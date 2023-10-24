public Boolean validParenthesisStack() {
        char[] input = new char[]{'(', ')','[',']','{','}','[','(','{','}',')',']','(','}'};
        Stack<Character> characters = new Stack<>();

        for(int i=0; i< input.length; i++) {
            if(input[i] == '(' || input[i] == '[' || input[i] == '{') {
                characters.push(input[i]);
            } else {
                if((input[i] == ')' && characters.pop()!='(') || (input[i] == ']' && characters.pop()!='[') || (input[i] == '}' && characters.pop()!='{')) {
                    return false;
                }
            }
        }
        return characters.empty();
    }
