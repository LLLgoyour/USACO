//from CSES problem set: https://cses.fi/problemset/task/1621
/*
Time limit: 1.00 s Memory limit: 512 MB
You are given a list of n integers, and your task is to calculate the number of distinct values in the list.

Input

The first input line has an integer n: the number of values.

The second line has n integers x1,x2,…,xn.

Output

Print one integers: the number of distinct values.

Constraints
1≤n≤2⋅105
1≤xi≤109
Example

Input:
5
2 3 2 2 3

Output:
2
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

        int n = io.nextInt();

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(io.nextInt());
        }
        
        io.println(set.size());

        io.close();
        
        // BufferReader lo = new BufferReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(lo.readLine());
        // StringTokenizer StringTokenizer = new StringTokenizer(lo.readLine());
        // int[] arr = new int[n];
        //     for (int i = 0; i < n; i++) {
        //     arr[i] = Integer.parseInt(lo.nextToken());
        //     }
        // Arrays.sort(arr);
        // int ans = 1;
        //     for (int i = 0; i < n; i++) {
        //     if (arr[i] != arr[i - 1]) {
        //         ans++;
            }
}

class Kattio extends PrintWriter {
    private BufferedReader r;
    private StringTokenizer st;
    // standard input
    public Kattio() { this(System.in,System.out); }
    public Kattio(InputStream i, OutputStream o) {
        super(o);
        r = new BufferedReader(new InputStreamReader(i));
    }
    // USACO-style file input
    public Kattio(String problemName) throws IOException {
        super(new FileWriter(problemName+".out"));
        r = new BufferedReader(new FileReader(problemName+".in"));
    }
    // read next line
    public String readLine() {
        try {
            return r.readLine();
        } catch (IOException e) {}
        return null;
    }
    // returns null if no more input
    public String next() {
        try {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(r.readLine());
            return st.nextToken();
        } catch (Exception e) {}
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