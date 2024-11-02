import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1000000007;
    static int N;
    static long[] p;
    static List<List<Integer>> graph;
    static long[] probabilities;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            br.readLine();

            String[] nm = br.readLine().split(" ");
            N = Integer.parseInt(nm[0]);
            int M = Integer.parseInt(nm[1]);

            p = new long[N];
            String[] pStr = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                p[i] = Long.parseLong(pStr[i]);
            }

            graph = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                String[] uv = br.readLine().split(" ");
                int u = Integer.parseInt(uv[0]) - 1;
                int v = Integer.parseInt(uv[1]) - 1;
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            probabilities = new long[N];
            Arrays.fill(probabilities, 0);

            for (int length = 1; length <= N * N; length++) {
                dfs(0, 0, length, 1);
            }

            StringBuilder sb = new StringBuilder();
            for (long probability : probabilities) {
                sb.append(probability).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    static void dfs(int node, int depth, int targetLength, long probability) {
        if (depth > targetLength || probability == 0)
            return;

        if (depth > 0) {
            probabilities[node] = (probabilities[node] + probability) % MOD;
        }

        if (depth == targetLength)
            return;

        for (int next : graph.get(node)) {
            dfs(next, depth + 1, targetLength, (probability * p[next]) % MOD);
        }
    }
}
