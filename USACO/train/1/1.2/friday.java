/*
ID: lllgoyo2
LANG: JAVA
TASK: friday
 */

import java.io.*;

public class friday {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        int n = Integer.parseInt(in.readLine());
        in.close();
        int[] days = new int[7];
        int[] monthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int dayOfWeek = 0;
        for (int i = 0; i < n; i++) {
            int year = 1900 + i;
            for (int month = 0; month < 12; month++) {
                days[dayOfWeek]++;
                int daysInMonth = monthDays[month];
                if (month == 1 && isLeapYear(year)) {
                    daysInMonth = 29;
                }
                dayOfWeek = (dayOfWeek + daysInMonth) % 7;
            }
        }
        out.println(days[0] + " " + days[1] + " " + days[2] + " " + days[3] + " " + days[4] + " "
                + days[5] + " " + days[6]);
        out.close();
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else if (year % 400 != 0) {
            return false;
        } else {
            return true;
        }
    }
}
