package P1242;

import java.io.*;
import java.util.*;

public class Hanoii {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] init = new int[3][n];
        int[][] target = new int[3][n];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                init[i][j++] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                target[i][j++] = Integer.parseInt(st.nextToken());
            }
        }
        pw.close();
    }

    static void tryMove(int[][] init, int[][] target, int n, int from, int to, int via, PrintWriter pw) {
        if (n == 1) {
            pw.println("move " + init[from][0] + " from " + (char) ('A' + from) + " to " + (char) ('A' + to));
            return;
        }
        tryMove(init, target, n - 1, from, via, to, pw);
        pw.println("move " + init[from][n - 1] + " from " + (char) ('A' + from) + " to " + (char) ('A' + to));
        tryMove(init, target, n - 1, via, to, from, pw);
    }
}

/*
 * 题目描述
 * 设有
 * n 个大小不等的中空圆盘，按从小到大的顺序从1 到n 编号。将这n 个圆盘任意的迭套在三根立柱上，
 * 立柱的编号分别为 A, B, C，这个状态称为初始状态。
 * 
 * 现在要求找到一种步数最少的移动方案，使得从初始状态转变为目标状态。
 * 
 * 移动时有如下要求：
 * 
 * 一次只能移一个盘；
 * 不允许把大盘移到小盘上面。
 * 
 * 输入格式
 * 第一行一个整数，状态中圆盘总数n。
 * 
 * 接下来三行每行若干个整数，分别代表初始状态下A ,B ,C 柱子上的圆盘从上到下的编号，如果只有一个数0
 * 就代表这根柱子上没有数。
 * 接下来三行每行若干个整数，分别代表目标状态下A ,B ,C 柱子上的圆盘从上到下的编号，如果只有一个数0
 * 就代表这根柱子上没有数。
 * 
 * 输出格式
 * 若干行每行一个字符串，格式为 move I from P to Q ，代表一个移动的操作。
 * 
 * 接下来一行一个整数，代表从初始状态到目标状态的最少步数。
 * 
 * input
 * 5
 * 3 3 2 1
 * 2 5 4
 * 0
 * 1 2
 * 3 5 4 3
 * 1 1
 * 
 * output
 * move 1 from A to B
 * move 2 from A to C
 * move 1 from B to C
 * move 3 from A to B
 * move 1 from C to B
 * move 2 from C to A
 * move 1 from B to C
 * 7
 */