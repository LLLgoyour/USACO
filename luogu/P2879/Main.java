package P2879;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        HashMap<Integer, Integer> Pairs = new HashMap<Integer, Integer>();
        int n = s[0], i = s[1], h = s[2], r = s[3];
        Pairs.put(i, h); // maximum height
        for (int j = 0; j < n; j++) {
            if (j = i - 1) {
                continue;
            }
            Pairs.put(j, h - 1);
        }

        for (int j = 0; i < r; i++) {
            s = in.readLine().split(" ");
            Pairs.put(s[0], h - 1);
            Pairs.put(s[1], h - 1);
        }

    }
}