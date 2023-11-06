import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Integer> minMaxDq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int[] temp = new int[3];
            while (i < k) {
                temp[i] = Integer.parseInt(st.nextToken());
            }
            while (i > k - 1) { // assume k = 3 here
                temp[0] = temp[1];
                temp[1] = temp[2];
            }
            temp[2] = Integer.parseInt(st.nextToken());

            Integer.parseInt(st.nextToken());
            while (!minDq.isEmpty() && temp <= minDq.getLast()) {
                minDq.removeLast();
            }
            minDq.addLast(temp);

            if (i - k >= 0 && arr[i - k] == minDq.getFirst()) {
                minDq.removeFirst();
            }

            if (i < k - 1)
                continue;
            System.out.print(minDq.getFirst() + " ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            while (!maxDq.isEmpty() && temp >= maxDq.getLast()) {
                maxDq.removeLast();
            }
            maxDq.addLast(temp);
            if (i - k >= 0 && arr[i - k] == maxDq.getFirst()) {
                maxDq.removeFirst();
            }
            if (i < k - 1)
                continue;
            System.out.print(maxDq.getFirst() + " ");
        }
        br.close();
    }
}