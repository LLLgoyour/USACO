package P1002;

import java.io.*;
import java.util.*;

public class Ma {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());
        long l = Long.parseLong(st.nextToken());
        long[][] x = new long[25][25];
        long[][] horse = new long[25][25];
        long ans = 0;
        public Horse(long x, long y) {
            this.x = s;
            this.y = l;

        }
        // for (long i = 0; i < n; i++) {
        // for (long j = 0; j < m; j++) {
        // if (i == s - 3) {
        // if (j == l)

        // }
        // if (i == s - 2) {
        // if (j == l - 2) {
        // break;
        // }
        // ans++;
        // }
        // if (i == s - 1) {
        // if (j == l - 2) {
        // break;
        // }
        // ans++;
        // }
        // if (i == s) {
        // if (j == l) {
        // i += 1;
        // j -= 1;
        // continue;
        // }
        // ans++;
        // }
        // if (i == s + 1) {
        // if (j == l - 2) {
        // i += 1;
        // j -= 1;
        // break;
        // }
        // if (j == l + 2) {
        // i += 1;
        // j -= 2;
        // break;
        // }
        // ans++;
        // }
        // if (i == s + 2) {
        // if (j == l - 1) {
        // if (n > s) {
        // i += 1;
        // j -= 1;
        // } else {
        // break;
        // }
        // }
        // if (j == l + 1) {
        // if (n > s) {
        // i += 1;
        // j -= 1;
        // } else {
        // break;
        // }
        // }
        // ans++;
        // }
        // }
        // }
        pw.println(ans);
        pw.close();
    }
}

// long a, b, n, m,x[23][23],ma[23][23];

// void work(long long x,long long y){
// ma[x][y]=1;
// ma[x-1][y-2]=1;
// ma[x-2][y-1]=1;
// ma[x-2][y+1]=1;
// ma[x-1][y+2]=1;
// ma[x+1][y-2]=1;
// ma[x+2][y-1]=1;
// ma[x+2][y+1]=1;
// ma[x+1][y+2]=1;
// }

// long main(){
// scanf("%lld %lld %lld %lld",&n,&m,&a,&b);
// a++;
// b++;
// n++;
// m++;
// work(a,b);
// x[1][1]=1;
// for(long i=1;i<=n;i++){
// for(long j=1;j<=m;j++){
// if(i==1&&j==1)continue;
// if(ma[i][j]==0)x[i][j]=x[i-1][j]+x[i][j-1];
// }
// }
// printf("%lld",x[n][m]);
// return 0;
// }