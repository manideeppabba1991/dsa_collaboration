
// This is a JavaScript coding problem from BFE.dev 
// https://bigfrontend.dev/problem/implement-Array-prototype.flat

/**
 * @param { Array } arr
 * @param { number } depth
 * @returns { Array }
 */
function flat(arr, depth = 1) {
  // your imeplementation here
  if(!depth) return arr;

  return arr.reduce((acc, item) => acc.concat(Array.isArray(item) ? flat(item, depth - 1) : item), []);
}

console.log(flat([1,2,[3,[4,5,[6]]]])); //[ 1, 2, 3, [ 4, 5, [ 6 ] ] ]
console.log(flat([1,2,[3,[4,5,[6]]]], 2)); //[ 1, 2, 3, 4, 5, [ 6 ] ]
console.log(flat([1,2,[3,[4,5,[6]]]], 3)); //[ 1, 2, 3, 4, 5, 6]