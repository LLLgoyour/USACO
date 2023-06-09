import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        in.close();
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 0;
            }
            if (count == 6) {
                System.out.println("YES");
                break;
            }
        }
        if (count != 6) {
            System.out.println("NO");
        }

    }
}
