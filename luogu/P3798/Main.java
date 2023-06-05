import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = 0, m = 0;
        // input n and m in each line:
        System.out.println("input n and m in next two lines:");
        n = Integer.parseInt(in.readLine());
        m = Integer.parseInt(in.readLine());
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = 0;
            }
        }
        boolean canMove = hasAdjacentElements(n, m, grid);


    public static boolean hasAdjacentElements(int n, int m, int[][] array) {
        int row = n;
        int col = m;

        int rowMask = 0;
        int colMask = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int curr = array[i][j];
                int currBit = 1 << curr;

                if ((rowMask & currBit) != 0 || (colMask & currBit) != 0) {
                    return true;
                }

                rowMask |= currBit;
                colMask |= currBit << j;
            }
        }

        return false;
    }
