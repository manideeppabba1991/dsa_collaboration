
/**
 * @param {number[]} arr
 */
function selectionSort(arr) {
  // your code here

  for(let i = 0; i < arr.length - 1; i++) {
    // Sort each element by finding the next min element;
    let minIndex = i;
    for(let j = i+1; j < arr.length; j++) {
        // starting from i+1, find the index of min element
        if(arr[j] < arr[minIndex]) {
            minIndex =j;
        }
    }
    // swap the current ith index number with minIndex number
    [arr[i], arr[minIndex]] = [arr[minIndex], arr[i]];
  }
  return arr;
}

console.log(selectionSort([1,4,2,5,6, 87, 24, 98]));