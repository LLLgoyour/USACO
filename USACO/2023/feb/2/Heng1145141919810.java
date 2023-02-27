import java.util.*;
// © 2023 Feb. LLLgoyour. All Rights Reserved.

public class Heng1145141919810 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // the number of the test cases
        in.nextLine();
        while (t-- > 0) {
            int n = in.nextInt();
            in.nextLine();
            char[][] canvas = new char[n][n];
            for (int i = 0; i < n; i++) {
                canvas[i] = in.nextLine().toCharArray();
            }
            int k = in.nextInt();
            in.nextLine();
            char[][] stamp = new char[k][k];
            for (int i = 0; i < k; i++) {
                stamp[i] = in.nextLine().toCharArray();
            }
            boolean canCreate = canCreateStampPainting(canvas, stamp);
            System.out.println(canCreate ? "YES" : "NO");
            if (t > 0) {
                in.nextLine();
            }
        }
        in.close();
    }

    private static boolean canCreateStampPainting(char[][] canvas, char[][] stamp) {
        int n = canvas.length;
        int k = stamp.length;
        for (int rot = 0; rot < 4; rot++) /* rotation */ {
            for (int i = 0; i <= n - k; i++) {
                for (int j = 0; j <= n - k; j++) {
                    boolean match = true;
                    for (int x = 0; x < k; x++) {
                        for (int y = 0; y < k; y++) {
                            if (stamp[x][y] == '*' && canvas[i + x][j + y] == '.') {
                                match = false;
                                break;
                            }
                        }
                        if (!match) {
                            break;
                        }
                    }
                    if (match) {
                        return true;
                    }
                }
            }
            stamp = rotateStamp(stamp);
        }
        return false;
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
}
