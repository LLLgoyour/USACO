import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer m = Integer.parseInt(st.nextToken());
        Integer n = Integer.parseInt(st.nextToken());
        int[] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        Max(arr, m, n);
    }

    public static void Max(int[] arr, int m, int n) {
        int max = 0;

        System.out.println(max);
    }
}
