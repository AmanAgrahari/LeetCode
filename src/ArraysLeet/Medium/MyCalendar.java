package ArraysLeet.Medium;

import java.util.ArrayList;
import java.util.List;

class MyCalendar {
    static class Interval {
        int st;
        int en;

        Interval(int st, int en) {
            this.st = st;
            this.en = en;
        }
    }

    List<Interval> intervals;

    public MyCalendar() {
        intervals = new ArrayList<>();
    }

    boolean overlap(Interval i1, Interval i2) {
        int a = i1.st;
        int b = i1.en;
        int c = i2.st;
        int d = i2.en;
        return (a< d && c< b);
    }

    public boolean book(int start, int end) {
        Interval v = new Interval(start, end);
        if (intervals.size() == 0) {
            intervals.add(0, v);
            return true;
        }
        for (int i = 0; i < intervals.size(); ++i) {
            if (overlap(v, intervals.get(i))) {
                return false;
            }
        }
        intervals.add(v);
        return true;
    }

    public static void main(String[] args) {
        MyCalendar obj = new MyCalendar();
        System.out.println(obj.book(10, 20));
        System.out.println(obj.book(15, 25));
        System.out.println(obj.book(20, 30));
    }
}