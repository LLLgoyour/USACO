import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int tQuan = 0;
        int n;
        int k;
        while (t-- > 0) {
            br.readLine();
            n = Integer.parseInt(br.readLine());
            char[][] canvas = new char[n][n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < n; j++) {
                    canvas[i][j] = line.charAt(j);
                    if (canvas[i][j] == '*') {
                        tQuan++;
                    }
                }
            }
            k = Integer.parseInt(br.readLine());
            char[][] stamp = new char[k][k];
            for (int i = 0; i < k; i++) {
                String line = br.readLine();
                for (int j = 0; j < k; j++) {
                    stamp[i][j] = line.charAt(j);
                }
            }

            char[][][] stamps = { stamp, rotStamp(stamp), rotStamp(rotStamp(stamp)),
                    rotStamp(rotStamp(rotStamp(stamp))) };

            for (int i = 0; i <= n - k; i++) {
                for (int j = 0; j <= n - k; j++) {
                    boolean dot = true;
                    for (int di = 0; di < k; di++) {
                        for (int dj = 0; dj < k; dj++) {
                            if (stamp[di][dj] == '*' && canvas[i + di][j + dj] == '.') {
                                dot = false;
                                break;
                            }
                        }
                        if (!dot) {
                            break;
                        }
                    }
                    if (dot) {
                        for (char[][] s : stamps) {
                            draw(s, canvas, i, j);
                        }
                    }
                }
            }

            int amount = 0;
            for (char[] line : canvas) {
                for (char c : line) {
                    if (c == '!') {
                        amount++;
                    }
                }
            }
        }
        List<char[][]> stamps = new ArrayList<>();
        String ss = "";
        for (int i = 0; i < stamp[i].length; i++) {
            for (int j = 0; j < stamp[j].length; j++) {
                ss += stamp[i][j];
            }
            ss += "\n";
        }
        String stampString = ss.toString();

        stamps.add(stampString);
        for (int i = 1; i <= 3; i++) {
            stamps.add(rotStamp(stamps.get(stamps.length - 1)));
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + k - 1 >= n || i + k - 1 >= n) {
                    continue;
                }
                for (char[][] s : stamps) {
                    draw(s, canvas, i, j);
                }
            }
        }

        int amount = 0;
        for (char[] line : canvas) {
            for (char c : line) {
                if (c == '!') {
                    amount++;
                }
            }
        }
        if (amount == tQuan) {
            pw.println("YES");
        } else {
            pw.println("NO");
        }
        pw.close();
    }

    public static char[][] rotStamp(char[][] s) {
        int k = stamp.length;
        char[][] rot = new char[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                rot[i][j] = stamp[k - j - 1][i];
            }
        }
        return rot;
    }

    static void draw(char[][] stamp, char[][] canvas, int i, int j) {
        boolean dot = true;
        for (int di = 0; di < k; di++) {
            for (int dj = 0; dj < k; dj++) {
                if (stamp[di][dj] == '*' && canvas[i + di][j + dj] == '.') {
                    dot = false;
                    break;
                }
            }
            if (!dot) {
                break;
            }
        }
        if (dot) {
            for (int di = 0; di < k; di++) {
                for (int dj = 0; dj < k; dj++) {
                    if (canvas[i + di][j + dj] == '*' && stamp[di][dj] == '*') {
                        canvas[i + di][j + dj] = '!';
                    }
                }
            }
        }
    }
}
