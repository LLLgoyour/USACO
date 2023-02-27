import java.util.*;
import java.io.*;

public class Haybale {
    public static void main(String[] args) throws Exception {
        FastIO io = new FastIO();
        int n = io.nextInt();
        long t = io.nextLong();
        long count = 0;
        long hb = 0;
        long[][] deliveries = new long[n][2];

        for (int i = 0; i < n; i++) {
            deliveries[i][0] = io.nextLong();
            deliveries[i][1] = io.nextLong();
        }

        for (int i = 0; i < n; i++) {
            hb += deliveries[i][1];
            if (n == 1) {
                if (deliveries[i][0] < t) {
                    if (hb >= t) {
                        count += t;
                        break;
                    } else {
                        count += hb;
                        break;
                    }
                }
            }
            if (i > 0) {
                if (deliveries[i][0] - deliveries[i - 1][0] + 1 <= (hb - deliveries[i][1])) {
                    count += deliveries[i][0] - deliveries[i - 1][0];
                    hb -= deliveries[i][0] - deliveries[i - 1][0];
                } else {
                    count += hb - deliveries[i][1];
                    hb = deliveries[i][1];
                }
            }
            if (deliveries[i][0] >= t) {
                if (hb > 0) {
                    if (hb > (t - deliveries[i][0])) {
                        count += t - deliveries[i][0] + 1;
                        break;
                    }
                    count += hb;
                    break;
                } else {
                    break;
                }
            }
        }
        io.println(count);
        io.close();
    }
}

class FastIO extends PrintWriter {
    private InputStream stream;
    private byte[] buf = new byte[1 << 16];
    private int curChar;
    private int numChars;

    public FastIO() {
        this(System.in, System.out);
    }

    public FastIO(InputStream i, OutputStream o) {
        super(o);
        stream = i;
    }

    public FastIO(String i, String o) throws IOException {
        super(new FileWriter(o));
        stream = new FileInputStream(i);
    }

    private int nextByte() {
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars == -1) {
                return -1; // end of file
            }
        }
        return buf[curChar++];
    }

    public String next() {
        int c;
        do {
            c = nextByte();
        } while (c <= ' ');

        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = nextByte();
        } while (c > ' ');
        return res.toString();
    }

    public String nextLine() {
        int c;
        do {
            c = nextByte();
        } while (c == '\n' || c == '\r');

        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = nextByte();
        } while (c != -1 && c != '\n' && c != '\r');
        return res.toString();
    }

    public int nextInt() {
        int c;
        do {
            c = nextByte();
        } while (c <= ' ');

        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = nextByte();
        }

        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res = 10 * res + c - '0';
            c = nextByte();
        } while (c > ' ');
        return res * sgn;
    }

    public long nextLong() {
        long c;
        do {
            c = nextByte();
        } while (c <= ' ');

        long sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = nextByte();
        }

        long res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res = 10 * res + c - '0';
            c = nextByte();
        } while (c > ' ');
        return res * sgn;
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}