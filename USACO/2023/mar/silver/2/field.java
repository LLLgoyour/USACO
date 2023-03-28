import java.io.*;
import java.util.*;

public class field {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[1]);
        String[] t = new String[N];
        for (int i = 0; i < N; i++) {
            t[i] = br.readLine();
        }
        int[] cow = new int[N];
        for (int i = 0; i < N; i++) {
            cow[i] = convertStringToInteger(t[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            ans[i] = maxDiff(cow[i], cow, map);
        }
        for (int i = 0; i < N; i++) {
            pw.println(ans[i]);
        }
        pw.close();
    }

    static int maxDiff(int num, int[] cow, Map<Integer, Integer> map) {
        if (map.containsKey(num)) {
            return map.get(num);
        }
        int ans = 0;
        for (int j = 0; j < cow.length; j++) {
            ans = Math.max(ans, Integer.bitCount(num ^ cow[j]));
        }
        map.put(num, ans);
        return ans;
    }

    static int diff(int d1, int d2) {
        int count = 0;
        while (d1 != 0) {
            count++;
            d1 &= (d1 - 1);
        }
        return count - diff(d2 & d1, d2 & ~d1);
    }

    static int convertStringToInteger(String str) {
        int con = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'G') {
                con = (con << 1) | 1;
            } else if (c == 'H') {
                con = (con << 1) | 0;
            }
        }
        return con;
    }
}