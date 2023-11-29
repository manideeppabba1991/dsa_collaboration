function longestUniqueSubstr(str) {
    // your code here
    let map = new Map();
    let max = [0,0,0];
    let windowStart = 0;
    let windowEnd = 0
    for(; windowEnd < str.length; windowEnd++) {
      let char = str.charAt(windowEnd);
      
      if(map.has(char)) {
        windowStart = Math.max(windowStart, map.get(char) + 1);
      }
      
      map.set(char, windowEnd);
  
      let distance = windowEnd - windowStart + 1;
      
      if(distance > max[0]) {
        max = [distance, windowStart, windowEnd]
      }
      
      console.log({windowStart, windowEnd, map, max})
    }
    
    return str.slice(max[1], max[2] + 1);
  }
  console.log(longestUniqueSubstr("a12#23"));