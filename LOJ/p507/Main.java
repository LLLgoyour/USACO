import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        StringTokenizer st = new StringTokenizer(line);

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] c = new int[n];
        int[] v = new int[k];

        line = in.readLine();
        int[] preSum = new int[n];
        st = new StringTokenizer(line);
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
            if (i == 0) {
                continue;
            }
            preSum[i] = preSum[i - 1] + c[i];
        }

        line = in.readLine();
        st = new StringTokenizer(line);
        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        in.close();

        int[] dp = new int[n];

    }
}
