import java.io.*;

public class Pareidolia {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String S = br.readLine();
        pw.println(total(S));
        pw.close();
    }

    private static long total(String S) {
        long count = 0;
        long[] preb = new long[S.length()];
        for (long i = S.length() - 4; i >= 0; i--) {
            long k = i;
            if (S.charAt((int) i) == 'b') {
                preb[(int) i] = b(S, i);
                count += preb[(int) i];
            } else {
                preb[(int) i] = preb[(int) i + 1];
                count += preb[(int) (i + 1)] * ((int) (k - i + 1));
            }
        }
        return count;
    }

    private static long b(String S, long start) {
        String bes = "bessie";
        long len = bes.length();
        long idx = 0;
        long count = 0;
        long total = 0;
        for (long i = start; i < S.length(); i++) {
            if (S.charAt((int) i) == bes.charAt((int) idx)) {
                idx++;
                if (idx == len) {
                    count++;
                    idx = 0;
                }
            }
            total += count;
        }
        return total;
    }
}