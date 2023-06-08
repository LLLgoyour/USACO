package P2879;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = s[0], i = s[1], h = s[2], r = s[3];
        int[] pair = new int[2];
        HashMap<Integer, Integer> Pairs = new HashMap<Integer, Integer>();
        for (int j = 0; i < r; i++) {
            s = in.readLine().split(" ");
            Pairs.put(s[0], s[1]);
        }

    }
}