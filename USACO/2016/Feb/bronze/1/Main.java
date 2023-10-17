import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("pails.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
        String[] in = br.readLine().split(" ");
        br.close();
        int x = Integer.parseInt(in[0]);
        int y = Integer.parseInt(in[1]);
        int m = Integer.parseInt(in[2]);
        int result = 0;
        for (int i = 0; i * x <= m; i++) {
            for (int j = 0; i * x + j * y <= m; j++) {
                if (i * x + j * y <= m && i * x + j * y > result) {
                    result = i * x + j * y;
                }
            }
        }
        pw.println(result);
        pw.close();
    }
}
