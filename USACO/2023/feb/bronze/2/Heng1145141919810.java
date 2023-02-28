import java.util.*;
import java.io.*;

public class Heng1145141919810 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken()); // the number of the test cases
        while (t-- > 0) {
            br.readLine();
            int correctAmount = 0;
            int n = Integer.parseInt(br.readLine());
            char[][] canvas = new char[n][n];
            for (int i = 0; i < n; i++) {
                canvas[i] = br.readLine().toCharArray();
                for (char c : canvas[i]) {
                    if (c == '*') {
                        correctAmount++;
                    }
                }
            }
            int k = Integer.parseInt(br.readLine());
            char[][] stamp = new char[k][k];
            for (int i = 0; i < k; i++) {
                stamp[i] = br.readLine().toCharArray();
            }
            char[][][] stamps = new char[4][k][k];
            stamps[0] = stamp;
            for (int i = 1; i < 4; i++) {
                stamps[i] = rotateStamp(stamps[i - 1]);
            }

            boolean dot = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j + k - 1 < n && i + k - 1 < n) {
                        for (int m = 0; m < 4; m++) {
                            if (drawStamp(stamps[m], canvas, i, j)) {
                                dot = true;
                                break;
                            }
                        }
                        if (dot) {
                            break;
                        }
                    }
                }
                if (dot) {
                    break;
                }
            }

            int amount = 0;
            for (char[] line : canvas) {
                for (char c : line) {
                    if (c == '!') /* check ! amount */ {
                        amount++;
                    }
                }
            }

            if (amount == correctAmount) {
                pw.println("YES");
            } else {
                pw.println("NO");
            }
        }
        pw.close();
    }

    private static char[][] rotateStamp(char[][] stamp) {
        int k = stamp.length;
        char[][] rotated = new char[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                rotated[i][j] = stamp[k - j - 1][i];
            }
        }
        return rotated;
    }

    public static boolean drawStamp(char[][] stamp, char[][] canvas, int x, int y) {
        boolean dot;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (stamp[i][j] == '*' && canvas[x + i][y + j] == '.') {
                    dot = false;
                    break;
                }
            }
            if (!dot) {
                break;
            } else {
                for (i = 0; i < k; i++) {
                    for (int j = 0; j < k; j++) {
                        if (stamp[x + i][y + j] == '*' && canvas[i][j] == '*') {
                            canvas[x + i][y + j] = '!'; // 如果没有错误, *->!
                        }
                    }
                }
            }
        }
    }
}
