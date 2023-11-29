
/**
 * @param {number[]} arr - ascending array with duplicates
 * @param {number} target
 * @return {number}
 */
function elementAfter(arr, target){
    // your code here
    let left = 0;
    let right = arr.length - 1;
    let lastSearch = -1;

    while(left <= right) {
      let mid = Math.floor((right + left) * 0.5);
      let num = arr[mid];
      console.log({mid, num, target});
      if(num <= target) {
        if(num === target) {
          lastSearch = mid;
        }
        left = mid+1;
      } else {
        right = mid - 1;
      }
    }
    
    console.log({lastSearch})
    
    if(lastSearch > -1 && lastSearch < arr.length - 1) {
      return arr[lastSearch + 1];
    } else {
      return undefined;
    }
  }

  console.log(elementAfter([1,2,3,4,4,4,4,100,100,1000], 4))