package P1019;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Shiritori {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }
    }

    private static String srtr(String[] str) {
        String s = str[0];
        for (int i = 1; i < str.length; i++) {
            if (s.charAt(s.length() - 1) == str[i].charAt(0)) {
                s += str[i];
            } else {
                return "";
            }
        }
        return "";
    }
}
