/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var backspaceCompare = function(s, t) {
    let p1 = s.length -1 ;
    let p2 = t.length - 1;

    let sCount = 0, tCount = 0;

    while(p1 >= 0 && p2 >= 0) {
        let s1 = s.charAt(p1);
        let t1 = t.charAt(p2);
        console.log({s1, t1, oldP1: p1, oldP2: p2});
        if(s1 === "#" || t1 === "#") {
            if(s1 === "#") {
                p1--;
                sCount++;
            }
            if(t1 === "#") {
                p2--;
                tCount++;
            } 
            console.log({p1, p2, sCount, tCount})
        } else if (tCount > 0 || sCount > 0) {
            if(sCount > 0 ) {
                sCount--;
                p1--;
            }
            if(tCount > 0) {
                tCount--;
                p2--;
            }
            console.log({p1, p2, sCount, tCount})
        } else if(s1 !== t1) {
            return false
        } else {
            p1--;
            p2--;
        }
    }
    return p1 < 0 && p2 < 0;
};

console.log({result: backspaceCompare("bxj##tw", "bxj###tw")});