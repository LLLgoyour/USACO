import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int dist = 0;
        int[][] fires = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] s = in.readLine().split(" ");
            fires[i][0] = Integer.parseInt(s[0]);
            fires[i][1] = Integer.parseInt(s[1]);
        }
        Arrays.sort(fires, (a, b) -> a[0] - b[0]);
        int start = fires[0][0];
        int end = fires[0][1];
        for (int i = 1; i < n; i++) {
            if (fires[i][0] <= end) {
                end = Math.max(end, fires[i][1]);
            } else {
                dist += end - start;
                start = fires[i][0];
                end = fires[i][1];
            }
        }
        dist += end - start;
        System.out.println(dist);
    }
}
