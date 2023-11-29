
/**
 * @param {number[]} arr
 */
function insertionSort(arr) {
  // your code here

  for(let i = 1; i < arr.length; i++) {
    for(let j = 0; j >= 0; j--) {
        if(arr[i] < arr[j]) {
            [arr[i], arr[j]] = [arr[j], arr[i]];
        }
    }
  }
  return arr;
}
console.log(insertionSort([1,4,2,5,6, 87, 24, 98]));