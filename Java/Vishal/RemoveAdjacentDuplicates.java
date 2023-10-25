public String RemoveAdjacentDuplicates() {
        String input = "asjjjkkkli";
        String output = "";
        char[] arrOfInput = input.toCharArray();
        int left = 0;
        int right = 1;
        output = String.valueOf(arrOfInput[left]);
        while(right<arrOfInput.length) {
            if(arrOfInput[left] != arrOfInput[right]) {
                output = output + arrOfInput[right];
            }
            left++;
            right++;
        }
        return output;
    }
