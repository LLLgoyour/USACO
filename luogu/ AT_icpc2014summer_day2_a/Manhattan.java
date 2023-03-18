import java.io.*;
import java.util.*;
import java.text.*;

public class Manhattan {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        double n = Double.parseDouble(st.nextToken());
        DecimalFormat df = new DecimalFormat("#.##########");
        pw.println(df.format(Math.max(Math.sqrt(2) * n, Math.floor(n) + 1)));
        pw.close();
    }
}