// type Interval = [number, number]

/**
 * @param {Interval[][]} schedules
 * @return {Interval[]}
 */
function findMeetingSlots(schedules) {
    // your code here
    let all = schedules.reduce((acc, item) => {
        if(item.length)acc = acc.concat(item);
        return acc;
    }, [])
    if(!all) return [[0, 24]];
    all = all.sort((a,b) => a[0] - b[0]);
    let merged = [];
    let result = [];
    merged.push(all[0])
    for(let i = 1; i < all.length; i++) {
      let [currStart, currEnd] = all[i];
      let [prevStart, prevEnd] = merged.pop();
      if(currStart <= prevEnd) {
        prevStart = Math.min(currStart, prevStart);
        prevEnd = Math.max(currEnd, prevEnd);
         merged.push([prevStart, prevEnd]);
      } else {
         merged.push([prevStart, prevEnd]);
         merged.push([currStart, currEnd]);
      }
     
    }
    let curr = 0;
    for(let i = 0; i < merged.length && curr < 24; i++) {
      let [start, end] = merged[i];
      if(curr < start) {
        result.push([curr, start]);
      }
      curr = end;
    }
    if(curr < 24) {
      result.push([curr, 24]);
    }
    return result;
  }

  console.log(findMeetingSlots([
    [[13,15], [11,12], [10,13]], //schedule for member 1
    [[8, 9]], // schedule for member 2
    [[13, 18]] // schedule for member 3
  ]))