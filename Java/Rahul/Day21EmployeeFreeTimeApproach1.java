
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class EmployeFreeTime {

    public static void main(String[] args){
        List<List<Interval>> input = new ArrayList<>();
        List<Interval> emp1 = new ArrayList<>();
        List<Interval> emp2 = new ArrayList<>();
        List<Interval> emp3 = new ArrayList<>();
        //[[[1,3],[6,7]],
        // [[2,4]],
        // [[2,5],[9,12]]]
        emp1.add(new Interval(1,3));
        emp1.add(new Interval(6,7));
        emp2.add(new Interval(2,4));
        emp3.add(new Interval(2,5));
        emp3.add(new Interval(9,12));
        input.add(emp1);
        input.add(emp2);
        input.add(emp3);

        List<Interval> combined = employeeFreeTime(input);
        for(Interval temp: combined){
            System.out.println();
            System.out.print("Interval " +temp.start +","+temp.end);
        }

    }
    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> combined = new ArrayList<>();

        for (List<Interval> temp: schedule) {
            combined.addAll(temp);
        }

        combined.sort(Comparator.comparingInt(value -> value.start));

        List<Interval> out = new ArrayList<>();
        Stack<Interval> mergeStack = new Stack<>();
        mergeStack.push(combined.get(0));

        Interval previous = combined.get(0);
        for(int i =1;i<combined.size();i++){
            Interval current = combined.get(i);

            if(current.start <= previous.end && previous.start <= current.end ){
                previous.start = Math.min(current.start, previous.start);
                previous.end = Math.max(current.end, previous.end);
            }else{
                Interval temp = new Interval();
                temp.start = previous.end;
                temp.end = current.start;
                out.add(temp);
                previous = current;
            }
        }
        return out;
    }
}

class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
}
