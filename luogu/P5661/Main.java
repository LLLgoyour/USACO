import java.util.*;
// import java.io.*;

// public class Main {
// public static void main(String[] args) throws IOException {
// BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
// int n = Integer.parseInt(in.readLine());
// int[][] arr = new int[n][3];
// int[] t = new int[n];
// int price = 0;
// int flag = 0;
// int exist = 0;
// for (int i = 0; i < n; i++) {
// String[] line = in.readLine().split(" ");
// for (int j = 0; j < 3; j++) { // input values
// arr[i][j] = Integer.parseInt(line[j]);
// }
// if (i != 0 && arr[i - 1][0] == 0) { // if last time choose subway
// int p = 0;
// while (p < n) { // record values of discount time
// if (t[p] == 0) {
// t[p] = arr[i - 1][2];
// flag++;
// break;
// }
// p++;
// }
// }
// if (i != 0 && arr[i][0] == 1) { // choose bus
// for (int p = exist; p < flag; p++) {
// if (arr[i][1] <= arr[p][1] && arr[i][2] - arr[p][2] <= 45) { // use only if
// price of bus is less
// // than subway of discounted time &&
// // ?time is less than 45min
// arr[i][1] = 0; // let current price be discounted
// arr[p][1] = -1; // let discount be used
// t[p] = 0; // discount be used, time be 0
// flag--; // discount be used, total number be less
// exist++;
// break;
// } else if (arr[i][2] - t[p] > 45) {
// t[p] = 0; // discount already expired, time be 0
// arr[p][1] = -1; // let discount be used
// flag--; // discount be used, total number be less
// exist = p + 1;
// }
// }
// }
// price += arr[i][1];
// }
// System.out.println(price);
// in.close();
// }
// }

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0, a = 0, b = 0, c = 0, fl = 0, flag = 0, ans = 0, tou = 0;
        n = sc.nextInt();
        piao[] p = new piao[100005];
        for (int i = 0; i < n; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            if (a == 0) {
                p[fl] = new piao();
                p[fl].x = b;
                p[fl].y = c;
                fl++;
                ans += b;
            } else {
                flag = 0;
                for (int j = tou; j < fl; j++) {
                    if (c - p[j].y <= 45 && b <= p[j].x) {
                        p[j].x = -1;
                        flag = 1;
                        break;
                    } else if (c - p[j].y > 45) {
                        tou = j + 1;
                    }
                }
                if (flag == 0)
                    ans += b;
            }
        }
        System.out.println(ans);
    }
}

class piao {
    int x;
    int y;
}