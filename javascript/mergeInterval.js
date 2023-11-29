
// Start, end

// Case1: No overlap
 //   1--------5
 //              6-----10

// Case 2: Overlap (currStartTime <= previousEndTime)
//  Case 2.1:  Previous End time == Curr Start Time
    //  1 ----- 5
    //          5 ---- 10
    // 1 --------- 10

    // case 2.2 Curr Start Time < previous end time
    // 1------5
    //    3--------10
    // 1 ------ 10
    
/*
1. If intervals are not in sorted fashion, use in-built sorting methods to sort by start times
2. Initialize a stack to store output and start by pushing the first interval into the stack.
3. Iterate thorugh the intervals starting at index 1,
    3.1 Get previousInterval by popping output stack
    3.2 Compare currentInterval start time with previousInterval end time
        3.2.1 If they do not overlap, push the previousInterval and CurrentInterval into output stack accordingly.
        3.2.2 else, merge the interval and push the merged interval (i.e., [Min(prevStart, currStart), Max(prevEnd, currEnd)]) into output stack
    3.3 repeat process until loop ends
4. Return the output stack in form of int[][]{}
5. After happy path is completed, look for edge cases in our input and add base conditions.
*/
