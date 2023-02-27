import java.util.*;
import java.io.*;

public class Mooloo {
    public static void main(String[] args) throws Exception {
        FastIO io = new FastIO();
        int n = io.nextInt();
        int k = io.nextInt();
        long[] d = new long[n];
        for (int i = 0; i < n; i++) {
            d[i] = io.nextLong();
        }

        long longK = k;
        long m = longK + 1;

        for (int i = 0; i < n - 1; i++) {
            long t = d[i + 1] - d[i]; // i-1
            if (t >= longK + 1) {
                m += longK + 1;
            } else {
                m += t;
            }
        }
        io.println(m);
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
