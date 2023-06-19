import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = Integer.parseInt(in.readLine());
            }
        }
    }
}
