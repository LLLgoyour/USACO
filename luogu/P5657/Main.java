import java.math.BigInteger;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] i = in.readLine().split(" ");
        int n = Integer.parseInt(i[0]);
        BigInteger k = new BigInteger(i[1]);
        in.close();

        BigInteger lastIdx = BigInteger.valueOf(2).pow(n - 1);
        boolean flag = false;

        while (lastIdx.compareTo(BigInteger.ZERO) > 0) {
            if (!flag) {
                if (k.compareTo(lastIdx) < 0)
                    System.out.print("0");
                else if (k.compareTo(lastIdx) >= 0) {
                    System.out.print("1");
                    k = k.subtract(lastIdx);
                    flag = true;
                }
            } else if (flag) {
                if (k.compareTo(lastIdx) < 0) {
                    System.out.print("1");
                    flag = false;
                } else if (k.compareTo(lastIdx) >= 0) {
                    System.out.print("0");
                    k = k.subtract(lastIdx);
                }
            }
            lastIdx = lastIdx.shiftRight(1);
        }
    }
}
