import java.io.*;

public class Pareidolia {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String s = br.readLine();
        int left = 0, right = 5, pointer = 0, count = 0, bessieCount = 0, result = 0;
        char[] chars = s.toCharArray();
        while (right < s.length()) {

            char c = s.charAt(right);
            if (c == 'b' || c == 'e' || c == 's' || c == 'i') {
                if (c == 'b')
                    bessieCount++;
                if (c == 'i' && bessieCount > 0) {
                    bessieCount--;
                    count++;
                }
            }
            right++;
            while (bessieCount == 0 && left < right) {
                char lc = s.charAt(left);
                if (lc == 'b' || lc == 'e' || lc == 's' || lc == 'i') {
                    if (lc == 'i')
                        bessieCount++;
                }
                left++;
            }
            result += count;
        }

        pw.println(result);
        pw.close();
    }
}
