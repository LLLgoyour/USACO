import java.util.*;
import java.io.*;

class Subarrays {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int[] a = new int[t];
        String n;
        char[] array;
        for (int i = 0; i < t; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            n = String.valueOf(st.nextToken());
            array[i] = n.toCharArray(st.nextToken());
            Character[] charObjectArray = ArrayUtils.toObject(array);
            pw.println(a[i] + "," + array[i]);
        }

        pw.close();
    }
}