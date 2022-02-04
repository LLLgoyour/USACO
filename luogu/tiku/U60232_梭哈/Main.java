import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] t = new int[n];
        int[] cnt = new int[1000000];
        for (int i = 0; i < n; i++) {
            t[i] = Integer.parseInt(st.nextToken());
            cnt[t[i]]++;
        }
        Arrays.sort(t);
        for (int i = t[n-1]; i >= 0; i--) {
            if (cnt[i] >= 1) {
                boolean flag = true;
                for (int j = i - 1; j >= i - 4; j--) {
                    if (cnt[j] == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println("S");
                    System.out.println(i);
                    return;
                }
            }
        }
        for (int i = t[n-1]; i >= 0; i--) {
            if (cnt[i] >= 4) {

                System.out.println("F");
                System.out.println(i);
                return;
            }
        }
        for (int i = t[n-1]; i >= 0; i--) {
            if (cnt[i] == 3) {

                System.out.println("T");
                System.out.println(i);
                return;
            }
        }
        for (int i = t[n-1]; i >= 0; i--) {
            if (cnt[i] == 2) {

                System.out.println("P");
                System.out.println(i);
                return;
            }
        }
        for (int i = t[n-1]; i >= 0; i--) {
            if (cnt[i] == 1) {

                System.out.println("Z");
                System.out.println(i);
                return;
            }
        }

    }

}
// import java.io.*;
// im

// class Main {
//     public static void main(String[] args) throws IOException 
//     {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
//         // get n

//         StringTokenizer tokenizer = new StringTokenizer(br);

//         int[] t = new int[n]; // array of total numbers
//         for (int i = 0; i < n; i++) 
//         {
//              t[i] = Integer.parseInt(tokenizer.nextToken()); // input every number parsed by space
//         }
//         Arrays.sort(t); // sort the array
//         for (int i = 0; i < n - 1; i++) 
//         {
//             if (t[i + 1] = t[i] -1) 
//             {
//                 int ShunZi = 0;
//                 ShunZi++;
//                     if (ShunZi = 5) 
//                     {
//                         System.out.println("S");
//                         System.out.println(t[i]);
//                     }
//             } else if (t[i] = t[i + 1])
//             {
//                 int Xiangtong = 0;
//                 Xiangtong++;
//             } else if () 
//             {

//             }
//         }
//     }
// }

// // #include<bits/stdc++.h>

// // using namespace std;long long a[1000000],u[1000000];

// // int main()
// // {
// //  std::ios::sync_with_stdio(false);
// //  int n,szflag,szmax=0,j,stflag,stmax=0,ttflag,ttmax=0,Pflag,Pmax=0;
// //  cin>>n;
// //  for(int i=0;i<n;i++)
// //   cin>>u[i];
// //  sort(u,u+n);
// //  memcpy(a,u,sizeof(u));
// //  int nb=unique(u,u+n)-u;
// //  for(int i=0;i<nb;i++)
// //  {
// //   szflag=1;
// //   for(j=i+1;j<i+5;j++)
// //   {
// //    if(u[j-1]+1!=u[j])szflag=0;
// //   }
// //   if(szflag==1)szmax=u[j-1];
// //  }
// //  if(szmax!=0){cout<<'S'<<endl<<szmax<<endl;return 0;}
// //  for(int i=0;i<n;i++)
// //  {
// //   stflag=1;
// //   for(j=i+1;j<i+4;j++)
// //   {
// //    if(a[j-1]!=a[j])stflag=0;
// //   }
// //   if(stflag==1)stmax=a[j-1];
// //  }
// //  if(stmax!=0){cout<<'F'<<endl<<stmax<<endl;return 0;}
// //  for(int i=0;i<n;i++)
// //  {
// //   ttflag=1;
// //   for(j=i+1;j<i+3;j++)
// //   {
// //    if(a[j-1]!=a[j])ttflag=0;
// //   }
// //   if(ttflag==1)ttmax=a[j-1];
// //  }
// //  if(ttmax!=0){cout<<'T'<<endl<<ttmax<<endl;return 0;}
// //  for(int i=0;i<n;i++)
// //  {
// //   Pflag=1;
// //   for(j=i+1;j<i+2;j++)
// //   {
// //    if(a[j-1]!=a[j])Pflag=0;
// //   }
// //   if(Pflag==1)Pmax=a[j-1];
// //  }
// //  if(Pmax!=0){cout<<'P'<<endl<<Pmax<<endl;return 0;}
// //  cout<<'Z'<<endl<<a[n-1]<<endl;
// //  return 0;
// // }