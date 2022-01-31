import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        Kattio io = new Kattio();
        
        int t = io.nextInt();
        int diceCombine = new int[t]; // dice's number
        for (int i = 0; i < t; i++) {
            diceCombine[i] = io.nextInt();
        }
        
        io.close();
    }
    
    public static boolean firstCombine(int[] DiceA, int[] DiceB) {
        int winTime;
        int loseTime;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (DiceA[i] > DiceB[j]) {
                    winTime++;
                } else if (DiceA[i] < DiceB[j]) {
                    loseTime++;
                }
            }
        }
        return winTime > loseTime;
    io.println(t);
    io.close();
    }
    
    public static boolean loop(int i) {
        if (i == 4) {
            return valid();
        }

        for (int j = 1; j <= 10; j++) {
            // solve this
            if (loop(i + 1)) return true;
        }

        return false;

    }
}   
    class Kattio extends PrintWriter {
    private BufferedReader r;
    private StringTokenizer st;

    // standard input
    public Kattio() {
        this(System.in, System.out);
    }

    public Kattio(InputStream i, OutputStream o) {
        super(o);
        r = new BufferedReader(new InputStreamReader(i));
    }

    // USACO-style file input
    public Kattio(String problemName) throws IOException {
        super(new FileWriter(problemName + ".out"));
        r = new BufferedReader(new FileReader(problemName + ".in"));
    }

    // read next line
    public String readLine() {
        try {
            return r.readLine();
        } catch (IOException e) {
        }
        return null;
    }

    // returns null if no more input
    public String next() {
        try {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(r.readLine());
            return st.nextToken();
        } catch (Exception e) {
        }
        return null;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}