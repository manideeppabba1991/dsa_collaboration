function compare(v1, v2) {
    // your code here
    let i = 0, j= 0;
    while(i < v1.length || j < v2.length) {
      const {currNum: n1, end: end1} = getNum(v1, i);
      const {currNum: n2, end: end2} = getNum(v2, j);
      console.log({n1, n2, end1, end2})
      if(n1 === n2) {
        i = end1;
        j = end2; 
      } else if(n1 < n2) {
        return -1;
      } else {
        return 1;
      }   
    }
    return 0;
  }
  
  const getNum = (str, startIndex = 0) => {
    let currNum = 0;
    while(startIndex < str.length) {
      let curr = str[startIndex];
      if(curr === ".") break;
      currNum = currNum * 10 + Number(curr);
      startIndex++;
    }
    return {currNum, end: startIndex + 1};
  }

  console.log(compare("12.1.0", "12.1.2"));