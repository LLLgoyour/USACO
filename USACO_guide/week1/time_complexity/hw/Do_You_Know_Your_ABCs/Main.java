import java.io.*;
import java.util.*;

//http://www.usaco.org/index.php?page=viewproblem2&cpid=1059&lang=zh


public class Main {
    static void main(String[] args) throws IOException
        {
            Kattio std = new Kattio(System.in);
            int[] values = new int[7];
			for (int i = 0; i < 7; i++) 
				values[i] = std.nextInt();
			Arrays.sort(values);
			int c = values[6] - values[1] - values[0];
			System.out.println(values[0]+" "+values[1]+" "+c);
        }
		// 存入数组 取最大 然后取剩余三个最大 用sort方法排序
		
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
