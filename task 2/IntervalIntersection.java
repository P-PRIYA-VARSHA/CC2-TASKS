import java.util.ArrayList;
import java.util.List;

class Interval {
    int start;
    int end;

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}

public class IntervalIntersection {

    public static List<Interval> intervalIntersection(List<Interval> list1, List<Interval> list2) {
        List<Interval> result = new ArrayList<>();
        int i = 0, j = 0;

        // Iterate over both lists
        while (i < list1.size() && j < list2.size()) {
            Interval a = list1.get(i);
            Interval b = list2.get(j);

            // Find the overlap between intervals a and b
            int startMax = Math.max(a.start, b.start);
            int endMin = Math.min(a.end, b.end);

            // Check if intervals intersect
            if (startMax <= endMin) {
                result.add(new Interval(startMax, endMin));
            }

            // Move the pointer of the interval which ends first
            if (a.end < b.end) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Interval> list1 = new ArrayList<>();
        list1.add(new Interval(1, 5));
        list1.add(new Interval(10, 14));
        list1.add(new Interval(16, 18));
        list1.add(new Interval(20, 24));

        List<Interval> list2 = new ArrayList<>();
        list2.add(new Interval(3, 7));
        list2.add(new Interval(12, 15));
        list2.add(new Interval(18, 22));

        List<Interval> intersections = intervalIntersection(list1, list2);

        System.out.println("Intersections:");
        for (Interval interval : intersections) {
            System.out.println(interval);
        }
    }
}
