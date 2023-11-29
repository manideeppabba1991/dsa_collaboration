

/**
 * @param {number[]} arr
 * @returns number
 */
function findSingle(arr) {
    let map = {};
    for(let i =0; i < arr.length; i++) {
      let num = arr[i];
      if(num in map) {
        delete map[num];
      } else {
        map[num] = 1;
      }
    }
    console.log({keys: Object.keys(map)})
    return Object.keys(map)[0];
  }
  
console.log(findSingle([1,1,2]));  