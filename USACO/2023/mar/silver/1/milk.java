import java.io.*;
import java.util.*;

public class milk {
    public static void main(String[] args) throws IOException {
        // Input and output
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // Read input
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        long originalSum = 0;
        long ans = 0;
        // Sort the array in ascending order
        int[] sortedA = a.clone();
        Arrays.sort(sortedA); // sorted original array
        int[] queryA = a.clone(); // reset in every query
        for (int k = 0; k < n; k++) {
            originalSum += (long) (k + 1) * sortedA[k];
        }
        // reset sum in every query according to the original array
        long sum = originalSum;
        int q = Integer.parseInt(br.readLine());

        // Process each query
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken());
            sum = originalSum;
            queryA = a.clone();
            // duandian
            pw.println("sum:" + sum);
            pw.println("beginning array:");
            for (int k = 0; k < n; k++) {
                pw.print(queryA[k] + " ");
            }
            // Replace the element at index idx with j
            int oldVal = a[idx];
            queryA[idx] = j;
            Arrays.sort(queryA);
            pw.println("sorted array:");
            for (int k = 0; k < n; k++) {
                pw.print(queryA[k] + " ");
            }
            idx = Arrays.binarySearch(sortedA, oldVal);
            int newIdx = Arrays.binarySearch(queryA, j);

            // Calculate the answer
            if (idx != newIdx) {
                if (idx < newIdx) {
                    for (int i = newIdx; i < n; i++) {
                        sum += (long) (i + 1) * queryA[i]; // out of bound?
                    }
                } else {
                    for (int i = newIdx; i < idx; i++) {
                        sum += (long) (i + 1) * queryA[i];
                    }
                }
            }
            ans = sum - (long) (oldVal) * (idx + 1) + (long) (j) * (newIdx + 1);
            pw.println(ans);
        }
        pw.close();
    }
}

// import java.io.*;
// import java.util.*;

// public class milk {
// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
// StringTokenizer st;

// int n = Integer.parseInt(br.readLine());
// int[] originalA = new int[n];
// st = new StringTokenizer(br.readLine());
// for (int i = 0; i < n; i++) {
// originalA[i] = Integer.parseInt(st.nextToken());
// }
// int[] a = originalA.clone();
// long ans = 0;
// int q = Integer.parseInt(br.readLine());

// while (q-- > 0) {
// st = new StringTokenizer(br.readLine());
// int idx = Integer.parseInt(st.nextToken()) - 1;
// int j = Integer.parseInt(st.nextToken());
// a = Arrays.copyOf(originalA, originalA.length);
// ans = 0;
// // Replace new value in each query with a[idx].
// a[idx] = j;
// Arrays.sort(a);
// // get the ans
// for (int k = 0; k < n; k++) {
// ans += (long) (k + 1) * a[k];
// }
// pw.println(ans);
// }
// pw.close();
// }
// }