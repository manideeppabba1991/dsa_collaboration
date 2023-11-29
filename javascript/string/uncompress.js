


/**
 * @param {string} str
 * @returns {string}
 */
function uncompress(str1) {
    // your code here
    
  
    const helper = (str, idx, times) => {
      let currNum = 0;
      let currStr = "";
      console.log({str, idx, times})
      while(idx < str.length) {
        let char = str[idx];
        if(isDigit(char)) {
          currNum = currNum*10 + Number(char);
        } else if (char === "(") {
          currStr += helper(str, idx+1, currNum);
          return currStr;
        } else if(char === ")") {
            console.log(`returning ${currStr.repeat(times)}`);
          return currStr.repeat(times);
        } else {
          currStr += char;
        }
        console.log({currNum, currStr})
        idx++;
      }
      
      console.log({currStr, currNum})
      return currStr;
    }
    return helper(str1, 0, 1);
  }
  
  function isDigit(char) {
    return !isNaN(Number(char));
  }
  
  
console.log(uncompress("2(BFE)"))  