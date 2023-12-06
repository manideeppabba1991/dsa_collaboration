import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeFreeTime {
    public static void main(String[] args) {
        //Employee1 meeting timings
        List<Interval> emp1 = new ArrayList<>();
        Interval e1Meeting1 = new Interval(1,2);
        Interval e1Meeting2 = new Interval(5,6);

        emp1.add(e1Meeting1);
        emp1.add(e1Meeting2);

        //Employee2 meeting timings
        Interval e2Meeting1 = new Interval(1,3);
        List<Interval> emp2 = new ArrayList<>();

        emp2.add(e2Meeting1);

        //Employee3 meeting timings
        List<Interval> emp3 = new ArrayList<>();
        Interval e3Meeting1 = new Interval(4,10);

        emp3.add(e3Meeting1);

        //Schedule of all employees in the organization
        List<List<Interval>> schedule = new ArrayList<>();

        schedule.add(emp1);
        schedule.add(emp2);
        schedule.add(emp3);


        //Find all employees combined free time
        List<Interval> freeTime = employeeFreeTime(schedule);
        System.out.println("Result freeTime: " + freeTime);

    }

    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> combined = new ArrayList<>();

        for (List<Interval> empMeeting : schedule) {
            combined.addAll(empMeeting);
        }

        //Sorting meetings based on start time
        combined.sort(Comparator.comparingInt(value -> value.start));
        System.out.println("Combined meetings: " + combined);

        List<Interval> result = new ArrayList<>();
        Interval previous = combined.get(0);

        for (int i = 1; i < combined.size(); i++) {
            Interval current = combined.get(i);

            if (current.start <= previous.end && previous.start <= current.end) { // check if meetings overlap or not, if overlap combine them
                previous.start = Math.min(current.start, previous.start);
                previous.end = Math.max(current.end, previous.end);
            } else { // no overlap, find the free time between previous and current
                Interval freeTime = new Interval();
                freeTime.start = previous.end;
                freeTime.end = current.start;
                result.add(freeTime);
                previous = current; //iterate through next meetings
            }
        }
        return result;
    }
}

class Interval {
    public int start;
    public int end;

    public Interval() {
    }

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }

    @Override
    public String toString() {
        return "Interval [start=" + start + ", end=" + end + "]";
    }

    
}
