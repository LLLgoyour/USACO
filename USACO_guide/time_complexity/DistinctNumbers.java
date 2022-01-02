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

public class DistinctNumbers {
    public static void main(String[] args) throws IOException {
        BufferReader lo = new BufferReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(lo.readLine());
        StringTokenizer StringTokenizer = new StringTokenizer(lo.readLine());
        int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(lo.nextToken());
            }
        Arrays.sort(arr);
        int ans = 1;
            for (int i = 0; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                ans++;
            }
        }
    }
}