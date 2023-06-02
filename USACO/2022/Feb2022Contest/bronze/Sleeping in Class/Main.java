import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception 
    {
        Kattio io = new Kattio();
        int t = io.nextInt(); //field times
        for (int i = 0; i < t; i++)
        {
            int groupNum = io.nextInt(); //total numbers
            for (int j = 0; j < n; j++)
            {
                int inputNum = io.nextInt();
                int[] numArray = new int(inputNum);
            } // can it be compared if equal while inputting?
        }
        for (int k = 0, k < numArray.length; k++)
        {
            if (numArray[k] != numArray[k+1])
            {
                numArray[k] + numArray[k+1];
                times++;
            }
            else if (numArray[k] == numArray[k+1])
            {
                break;
            }
        }
        io.close();
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
