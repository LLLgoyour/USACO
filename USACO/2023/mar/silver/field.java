import java.io.*;

public class field {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String[] input = br.readLine().split(" ");
        int C = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        String[] teams = new String[N];
        for (int i = 0; i < N; i++) {
            teams[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            int maxDiff = 0;
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;
                int diff = 0;
                for (int k = 0; k < C; k++) {
                    if (teams[i].charAt(k) != teams[j].charAt(k)) {
                        diff++;
                    }
                }
                maxDiff = Math.max(maxDiff, diff);
            }
            pw.println(maxDiff);
        }

        pw.close();
        br.close();
    }
}
