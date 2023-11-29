

// This is a JavaScript coding problem from BFE.dev 

/**
 * @param {string[][]} message
 * @return {string}
 */
function decode(message) {
    // your code here
    if(!message || !message.length) return "";
    let [row, col] = [0, 0];
    let rowLen = message.length;
    let colLen = message[0].length;
    if(!colLen) return "";
    let result = "" + message[0][0];
    let directions = [[1,1], [-1, 1]];
    let currDir = 0;
    const changeDirection = (curr) => curr === 0 ? 1 : 0;
    while(col < colLen ) {
      let dir = directions[currDir];
      let [newRow, newCol] = [row + dir[0], col + dir[1]];
      console.log({newRow, newCol});
      if (newCol >= colLen ){
        console.log("resturning result", result);
        break; 
      } else if(newRow >= rowLen || newRow < 0) {
        currDir = changeDirection(currDir);
      } else {
        result += message[newRow][newCol];
        row = newRow;
        col = newCol;
      }
    }
    return result;
  }
  
  console.log(decode([["A"], ["B"]]))
  
  
  
  