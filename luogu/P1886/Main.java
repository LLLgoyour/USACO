import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        br.close();
        Min(arr, n, k);
        Max(arr, n, k);
    }

    public static void Min(int[] arr, int n, int k) {
        Deque<Integer> minDq = new ArrayDeque<>();

        /*
         * 从 arr(i_0) 到 arr(i_(n-1)) 的元素入列, 相隔超过 k-1 的队首元素出列, 每个循环中 min(i) 和 max(i)
         * 为每个循环中对应队列队首元素
         */

        for (int i = 0; i < n; i++) {
            while (!minDq.isEmpty() && arr[i] <= minDq.getLast()) {
                minDq.removeLast();
            }
            minDq.addLast(arr[i]);

            if (i - k >= 0 && arr[i - k] == minDq.getFirst()) {
                minDq.removeFirst();
            }

            if (i < k - 1)
                continue;
            System.out.print(minDq.getFirst() + " ");
        }
    }

    public static void Max(int[] arr, int n, int k) {
        Deque<Integer> maxDq = new ArrayDeque<>();

        /*
         * 从 arr(i_0) 到 arr(i_(n-1)) 的元素入列, 相隔超过 k-1 的队首元素出列, 每个循环中 min(i) 和 max(i)
         * 为每个循环中对应队列队首元素
         */
        System.out.println();
        for (int i = 0; i < n; i++) {
            while (!maxDq.isEmpty() && arr[i] >= maxDq.getLast()) {
                maxDq.removeLast();
            }
            maxDq.addLast(arr[i]);
            if (i - k >= 0 && arr[i - k] == maxDq.getFirst()) {
                maxDq.removeFirst();
            }
            if (i < k - 1)
                continue;
            System.out.print(maxDq.getFirst() + " ");
        }
    }
}