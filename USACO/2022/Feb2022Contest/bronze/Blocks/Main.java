import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        char[] s = new char[4];
        for (int i = 1; i <= 4; i++)
            s[i] = in.readLine().toCharArray();
        for (int i = 1; i <= n; i++) {
            String word = in.readLine();
            for (int j = 0; j < 4; j++) {
                for (int p = 0; p < word.length(); p++) {

                }
            }
            System.out.println(flag ? "YES" : "NO");
        }
    }
}