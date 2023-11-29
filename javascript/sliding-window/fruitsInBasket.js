const fruitsInBasket = (arr, k = 2) => {
    let windowStart = 0;
    let map = new Map();
    let max = 0;
    for(let windowEnd = 0; windowEnd < arr.length; windowEnd++) {
        let fruit = arr[windowEnd];
        if(!map.has(fruit)) {
            map.set(fruit, 0);
        }
        map.set(fruit, map.get(fruit) + 1);
        while(map.size > k) {
            let prevFruit = arr[windowStart];
            windowStart++;
            let qty = map.get(prevFruit);
            if(qty === 1) {
                map.delete(prevFruit);
            } else {
                map.set(prevFruit, qty - 1);
            }
        }
        max = Math.max(max, (windowEnd - windowStart + 1));
    }
    return max;
}

console.log(fruitsInBasket([0,1,2,1]));