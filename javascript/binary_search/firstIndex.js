/**
 * @param {number[]} arr - ascending array with duplicates
 * @param {number} target
 * @return {number}
 */
function firstIndex(arr, target){
       // your code here
       let left = 0;
       let right = arr.length - 1;
       let firstIndex = -1;
   
       while(left <= right) {
         let mid = Math.floor((right + left) * 0.5);
         let num = arr[mid];
         console.log({mid, num, target});
         if(num >= target) {
           if(num === target) {
             firstIndex = mid; 
           }
           right = mid-1;
         } else {
           left = mid + 1;
         }
       }
       return firstIndex;
}