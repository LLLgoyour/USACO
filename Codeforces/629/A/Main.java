import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final boolean[][] bool = new boolean[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] isHappy = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                isHappy[i][j] = s.charAt(j) == '.' ? 1 : 0;
            }
        }
        br.close();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isHappy[i][j] == 1) {
                    ans++;
                    dfs(isHappy, i, j);
                }
            }
        }

    }

    public static void dfs(int[][] isHappy, int i, int j) {
        if (bool[i][j] == true) {
            return;
        }
        bool[i][j] = true;
        for (int i = 0; i < isHappy[i].length; i++) {
            if (isHappy[i][j] == 1) {
                dfs(isHappy, i, j);
            }
        }
    }
}
