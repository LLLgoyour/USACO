package P6159;

import java.io.*;
import java.util.*;

public class Cirno {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        pw.println((k * p) % n);
        pw.close();
    }
}
