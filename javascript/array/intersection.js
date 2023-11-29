/**
 * @param {any[]} arr1
 * @param {any[]} arr2
 * @returns {any[]}
 */
function getIntersection(arr1, arr2) {
    // your code here
    arr1.sort((a,b) => a-b);
    arr2.sort((a,b) => a-b);
    let i = 0;
    let j = 0;
    let result = [];
    while(i < arr1.length && j < arr2.length) {
      let n1 = arr1[i];
      let n2 = arr2[j];
      if(n1 === n2) {
        result.push(n1);
        while(arr1[i] === n1) i++;
        while(arr2[j] === n2) j++;
      } else if(n1 > n2) {
          j++;
      } else {
        i++;
      }
    }
    return result;
  }
  
  
  
  
console.log(getIntersection([1,100, 200, 8,8,8,3,6,100, 10, 10], [8, 7, 7, 50,50, 1,1,1,1,3,3]));  