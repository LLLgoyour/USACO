import java.util.*;

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