import java.io.*;
import java.util.*;

public class Square
{
    static void main(String[] args) throws IOException
    {
        Kattio io = new Kattio("square");
        int x1 = io.nextInt(), y1 = io.nextInt();
        int x2 = io.nextInt(), y2 = io.nextInt();
        int x3 = io.nextInt(), y3 = io.nextInt();
        int x4 = io.nextInt(), y4 = io.nextInt();

        int left = Math.min(x1, x3);
        int right = Math.max(x2, x4);
        int bottom = Math.min(y1, y3);
        int top = Math.max(y2, y4);

        int side = Math.max(right - left, top - bottom);
        io.println(side * side);
        io.close();
    }

    static class Kattio extends PrintWriter
    {
		private BufferedReader r;
		private StringTokenizer st;
	
		// standard input
		public Kattio() { this(System.in, System.out); }
		public Kattio(InputStream i, OutputStream o)
        {
			super(o);
			r = new BufferedReader(new InputStreamReader(i));
		}
		// USACO-style file input
		public Kattio(String problemName) throws IOException 
        {
			super(new FileWriter(problemName + ".out"));
			r = new BufferedReader(new FileReader(problemName + ".in"));
		}
	
		// returns null if no more input
		public String next()
        {
			try 
            {
				while (st == null || !st.hasMoreTokens())
					st = new StringTokenizer(r.readLine());
				return st.nextToken();
			} catch (Exception e)
            {
            }
			return null;
		}
	
		public int nextInt() { return Integer.parseInt(next()); }
		public double nextDouble() { return Double.parseDouble(next()); }
		public long nextLong() { return Long.parseLong(next()); }
	}
}

