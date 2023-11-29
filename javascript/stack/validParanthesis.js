function validate(str) {
    // your code here
    let stack = [];
    let map = {'}': '{', ']': '[', ')' : '('};
  
    for(let i = 0; i < str.length; i++) {
      let char = str.charAt(i);
      if(["(", "[", "{"].indexOf(char) > -1) {
        stack.push(char);
      } else {
        const poppedValue = stack.pop();
        
        console.log({poppedValue, char, condition: poppedValue !== map[char]})
        if(poppedValue !== map[char]) return false;
      }
    }
    console.log({stack});
    return stack.length === 0;
  }
  console.log(validate("{}()[]"));