import java.io.*;

public class Main {
    public static int[][] carpet(int[][] arr, int x, int y, int x1, int y1) {
        for (int i = x - 1; i < x1; i++) {
            for (int j = y - 1; j < y1; j++) {
                arr[i][j] += 1;
            }
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] arr = new int[n][n];
        while (m-- > 0) {
            s = in.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int x1 = Integer.parseInt(s[2]);
            int y1 = Integer.parseInt(s[3]);
            arr = carpet(arr, x, y, x1, y1);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
