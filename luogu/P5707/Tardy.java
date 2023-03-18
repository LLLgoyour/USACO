import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Tardy {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        Calendar date = Calendar.getInstance();
        date.set(2021, Calendar.MAY, 5, 7, 50, 0);
        date.add(Calendar.MINUTE, s % v == 0 ? -(s / v) : -(s / v) - 1);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        pw.println(format.format(date.getTime()));
        pw.close();
    }
}
