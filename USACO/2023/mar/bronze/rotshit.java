import java.util.*;
import java.io.*;

public class rotshit {

    static int n, k, t;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        // Read input values
        String[] line1 = br.readLine().split(" ");
        n = Integer.parseInt(line1[0]);
        k = Integer.parseInt(line1[1]);
        t = Integer.parseInt(line1[2]);
        a = new int[k];
        String[] line2 = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            a[i] = Integer.parseInt(line2[i]);
        }

        // Calculate the final order of cows after t minutes
        int[] order = calculateOrder();
        for (int i = 0; i < n; i++) {
            pw.print(order[i] + " ");
        }
        pw.println();
        pw.close();
    }

    static int[] calculateOrder() {
        int[] order = new int[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }

        // Simulate the dance for t minutes
        int prev, curr;
        for (int i = 0; i < t; i++) {
            // Rotate the cows in the active positions
            prev = a[0];
            for (int j = 1; j < k; j++) {
                curr = a[j];
                // Move the cow from the previous active position to the current one
                for (int p = curr - 1; p >= prev; p--) {
                    swap(order, p, p + 1);
                }
                prev = curr;
            }
            // Move the active positions
            for (int j = k - 1; j >= 1; j--) {
                a[j] = (a[j] + 1) % n;
            }
            a[0] = (a[0] + 1) % n;
        }

        return order;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
