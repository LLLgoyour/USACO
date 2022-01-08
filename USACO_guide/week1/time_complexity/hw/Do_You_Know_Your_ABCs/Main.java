import java.io.*;

//http://www.usaco.org/index.php?page=viewproblem2&cpid=1059&lang=zh

/*
Farmer John 的奶牛正在 "mooZ" 视频会议平台上举行每日集会。她们发明了一个简单的数字游戏，为会议增添一些乐趣。
Elsie 有三个正整数 A、B 和 C（A≤B≤C）。这些数字是保密的，她不会直接透露给她的姐妹 Bessie。她告诉 Bessie 七个范围在 1…109 之间的整数（不一定各不相同），并宣称这是 A、B、C、A+B、B+C、C+A 和 A+B+C 的某种排列。

给定这七个整数，请帮助 Bessie 求出 A、B 和 C。可以证明，答案是唯一的。

输入格式（从终端/标准输入读入）：
输入一行，包含七个空格分隔的整数。
输出格式（输出至终端/标准输出）：
输出 A、B 和 C，用空格分隔。
输入样例：
2 2 11 4 9 7 9
输出样例：
2 2 7
测试点性质：
测试点 2-3 满足 C≤50。
测试点 4-10 没有额外限制。
*/

public class Main {
    static void main(String[] args) throws IOException
        {
            Kattio io = new Kattio("main");
            int a = io.nextInt();
            int b = io.nextInt();
            int c = io.nextInt();
            int d = io.nextInt();
            int e = io.nextInt();
            int f = io.nextInt();
            int g = io.nextInt();
            
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
