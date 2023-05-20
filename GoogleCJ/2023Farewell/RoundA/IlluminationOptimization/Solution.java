import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] colors = new int[N];
            String[] parts = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                colors[i] = Integer.parseInt(parts[i]);
            }

            System.out.print("Case #" + t + ": ");

            int[] lastOccurrence = new int[100001];
            int[] smallestUnused = new int[100001];
            int nextUnused = 1;
            boolean impossible = false;

            for (int i = 0; i < N; i++) {
                int color = colors[i];

                if (lastOccurrence[color] != 0) {
                    if (smallestUnused[color] != 0 && smallestUnused[color] < nextUnused) {
                        impossible = true;
                        break;
                    }

                    smallestUnused[color] = nextUnused;
                    nextUnused++;
                }
                System.out.print(smallestUnused[color] + " ");
                lastOccurrence[color] = i + 1;
            }

            if (impossible) {
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
            } else {
                System.out.println();
            }
        }
    }
}
