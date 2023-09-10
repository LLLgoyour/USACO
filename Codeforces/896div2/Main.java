import java.util.*;
import java.io.*;

public class Main {
    static int N, A[];
    static List<int[]> operations = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            N = Integer.parseInt(br.readLine());
            A = new int[N + 1];
            String[] in = br.readLine().split(" ");
            for (int i = 1; i <= N; i++) {
                A[i] = Integer.parseInt(in[i - 1]);
            }
            if ((N & 1) == 1) {
                calc(1, N - 1);
                calc(1, N - 1);
                calc(2, N);
                calc(2, N);

            } else {
                calc(1, N);
                calc(1, N);
            }

            // Print the operations
            System.out.println(operations.size());
            for (int[] op : operations) {
                System.out.println(op[0] + " " + op[1]);
            }
        }
        br.close();
    }

    public static void calc(int l, int r) {
        int x = 0;
        for (int i = l; i <= r; i++) {
            x ^= A[i];
        }
        for (int i = l; i <= r; i++) {
            A[i] = x;
        }
        operations.add(new int[] { l, r });
        return;
    }
}
