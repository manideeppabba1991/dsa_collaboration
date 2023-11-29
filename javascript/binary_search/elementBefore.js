
/**
 * @param {number[]} arr - ascending array with duplicates
 * @param {number} target
 * @return {number}
 */
function elementBefore(arr, target){
    // your code here
    let left = 0,  right = arr.length - 1;
    let firstIndex = -1;

    while(left <= right) {
        let mid = Math.floor((left+right)*0.5);
        let num = arr[mid];

        if(num >= target) {
            right = mid - 1;
            if(num === target) {
                firstIndex = mid;
            }
        } else {
            left = mid + 1;
        }
    }

    return firstIndex > 0 ? arr[firstIndex - 1] : undefined;
}

console.log(elementBefore([1,2,3,4,4,4,4,100,100,1000], 4));