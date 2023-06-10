import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            br.readLine(); // 空行

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] C = new int[N];
            int[] S = new int[N];
            int[] F = new int[N];

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                C[i] = Integer.parseInt(st1.nextToken());
            }

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                S[i] = Integer.parseInt(st2.nextToken());
            }

            StringTokenizer st3 = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                F[i] = Integer.parseInt(st3.nextToken());
            }

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                StringTokenizer st4 = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st4.nextToken()) - 1;
                int v = Integer.parseInt(st4.nextToken()) - 1;
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            boolean[] visited = new boolean[N];
            visited[0] = true;

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);

            boolean found = false;

            while (!queue.isEmpty()) {
                int curr = queue.poll();

                // 检查当前房间是否需要的钥匙颜色与手上持有的钥匙颜色相匹配
                if (F[curr] != S[curr]) {
                    continue;
                }

                // 遍历当前房间中的所有钥匙颜色，将手上持有的钥匙进行放置
                for (int i = 0; i < N; i++) {
                    if (S[i] == C[curr]) {
                        S[i] = F[curr];
                    }
                }

                // 遍历当前房间的相邻房间
                for (int neighbor : graph.get(curr)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }

                // 如果房间1再次出现在队列中，则说明可以成功将钥匙放置在合适的位置并回到房间1
                if (queue.contains(0)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
