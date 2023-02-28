import java.util.*;

public class sbMoo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<List<int[]>> flights = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            flights.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int c = scanner.nextInt();
            int r = scanner.nextInt();
            int d = scanner.nextInt();
            int s = scanner.nextInt();

            flights.get(c).add(new int[] { d, r, s });
        }

        int[] layovers = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            layovers[i] = scanner.nextInt();
        }

        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        distances[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node[1]));
        pq.offer(new int[] { 1, 0 });

        boolean[] processed = new boolean[n + 1];

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int u = node[0];
            int dist = node[1];

            if (processed[u]) {
                continue;
            }
            processed[u] = true;

            for (int[] flight : flights.get(u)) {
                int v = flight[0];
                int r = flight[1];
                int s = flight[2];

                if (dist + s + layovers[u] < r && (distances[v] == -1 || dist + s + layovers[u] < distances[v])) {
                    distances[v] = dist + s + layovers[u];
                    pq.offer(new int[] { v, distances[v] });
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(distances[i]);
        }
    }
}
