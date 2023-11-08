/*
ID: lllgoyo2
LANG: JAVA
TASK: milk2
*/

import java.io.*;
import java.util.*;

public class milk2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        int num = Integer.parseInt(br.readLine());
        List<Interval> intervals = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            intervals.add(new Interval(start, end));
        }

        intervals.sort(Comparator.comparingInt(i -> i.start));

        int maxMilked = 0;
        int maxIdle = 0;

        int currentStart = intervals.get(0).start;
        int currentEnd = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= currentEnd) {
                currentEnd = Math.max(currentEnd, interval.end);
            } else {
                maxMilked = Math.max(maxMilked, currentEnd - currentStart);
                maxIdle = Math.max(maxIdle, interval.start - currentEnd);
                currentStart = interval.start;
                currentEnd = interval.end;
            }
        }

        maxMilked = Math.max(maxMilked, currentEnd - currentStart);

        out.println(maxMilked + " " + maxIdle);
        out.close();
        br.close();
    }

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}