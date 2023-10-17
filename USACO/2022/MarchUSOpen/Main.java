import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Pair p[] = new Pair[n];
        for (int i = 0; i < n; i++) { // input
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            char key = tokenizer.nextToken().charAt(0);
            int value = Integer.parseInt(tokenizer.nextToken());
            p[i] = new Pair(key, value);
        }

        int result = n;

        for (Pair i : p) {
            int liars = 0;
            int x = i.value;
            for (Pair j : p) {
                if (j.key == 'G' ? x < j.value : x > j.value) {
                    liars++;
                }
            }
            result = Math.min(result, liars);
        }
        System.out.println(result);
    }

    public static class Pair {
        final char key;
        final int value;

        public Pair(char key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
