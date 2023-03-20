package P1002;

/* credit to
* https://github.com/pufferfist/luogu/blob/master/popular/src/dp/P1002/Main.java
* by pufferfist...I don't know why mine occurs RE. */

// import java.io.*;
import java.util.*;

public class Ma {
    private long[][] board;

    public static void main(String[] args) {
        System.out.println(new Ma().execute());
    }

    private long execute() {
        Scanner s = new Scanner(System.in);
        int bx = s.nextInt();
        int by = s.nextInt();
        int x = s.nextInt();
        int y = s.nextInt();
        board = new long[bx + 1][by + 1];
        for (long[] i : board) {
            for (int j = 0; j < by + 1; j++) {
                i[j] = 0;
            }
        }
        if (x + 1 <= bx && y + 2 <= by)
            board[x + 1][y + 2] = -1;
        if (x + 1 <= bx && y - 2 >= 0)
            board[x + 1][y - 2] = -1;
        if (x - 1 >= 0 && y + 2 <= by)
            board[x - 1][y + 2] = -1;
        if (x - 1 >= 0 && y - 2 >= 0)
            board[x - 1][y - 2] = -1;
        if (x + 2 <= bx && y + 1 <= by)
            board[x + 2][y + 1] = -1;
        if (x + 2 <= bx && y - 1 >= 0)
            board[x + 2][y - 1] = -1;
        if (x - 2 >= 0 && y + 1 <= by)
            board[x - 2][y + 1] = -1;
        if (x - 2 >= 0 && y - 1 >= 0)
            board[x - 2][y - 1] = -1;
        if (board[0][0] == -1) {
            return 0;
        }
        board[0][0] = 1;
        board[x][y] = -1;
        return paths(bx, by);
    }

    private long paths(int a, int b) {
        if (board[a][b] == -1) {
            return 0;
        } else if (board[a][b] == 0) {
            long result = 0;
            if (a - 1 >= 0 && board[a - 1][b] != -1) {
                result += paths(a - 1, b);
            }
            if (b - 1 >= 0 && board[a][b - 1] != -1) {
                result += paths(a, b - 1);
            }
            board[a][b] = result;
            return result;
        } else {
            return board[a][b];
        }
    }
}

// public class Ma {
// static int n, m, s, l;
// static long[][] x = new long[23][23];
// static long[][] horse = new long[23][23];

// static void kankannide(int x, int y) {
// horse[x][y] = 1;
// horse[x - 1][y - 2] = 1;
// horse[x - 2][y - 1] = 1;
// horse[x - 2][y + 1] = 1;
// horse[x - 1][y + 2] = 1;
// horse[x + 1][y - 2] = 1;
// horse[x + 2][y - 1] = 1;
// horse[x + 2][y + 1] = 1;
// horse[x + 1][y + 2] = 1;
// }

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// PrintWriter pw = new PrintWriter(System.out);
// StringTokenizer st = new StringTokenizer(br.readLine());
// n = Integer.parseInt(st.nextToken());
// m = Integer.parseInt(st.nextToken());
// s = Integer.parseInt(st.nextToken());
// l = Integer.parseInt(st.nextToken());
// n++;
// m++;
// s++;
// l++;
// kankannide(s, l);
// x[1][1] = 1;
// for (int i = 1; i <= n; i++) {
// for (int j = 1; j <= m; j++) {
// if (i == 1 && j == 1)
// continue;
// if (horse[i][j] == 0)
// x[i][j] = x[i - 1][j] + x[i][j - 1];
// }
// }
// pw.println(x[n][m]);
// pw.flush();
// pw.close();
// }
// }