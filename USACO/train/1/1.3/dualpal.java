/*
ID: lllgoyo2
LANG: JAVA
TASK: dualpal
*/

import java.io.*;
import java.util.StringTokenizer;

public class dualpal {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("dualpal.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("dualpal.out"));
        StringTokenizer scanner = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(scanner.nextToken());
        int S = Integer.parseInt(scanner.nextToken());
        int count = 0;

        for (int i = S + 1; count < N; i++) {
            int numBases = 0;
            for (int base = 2; base <= 10; base++) {
                String result = Integer.toString(i, base);
                String reverse = new StringBuilder(result).reverse().toString();
                if (result.equals(reverse)) {
                    numBases++;
                }
            }

            if (numBases >= 2) {
                count++;
                out.write(Integer.toString(i));
                out.newLine();
            }
        }

        in.close();
        out.close();
    }
}
