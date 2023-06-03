import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[][] arr = new int[n][3];
        int[] t = new int[n + 1];
        int price = 0;
        for (int i = 0; i < n; i++) {
            String[] line = in.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
            if (i != 0 && arr[i - 1][0] == 0) {
                int p = 0;
                int flag = 0;
                while (p < n) {
                    if (t[p] == 0) {
                        t[p] = arr[i - 1][2];
                        flag++;
                    }
                    p++;
                }
                if (arr[i][1] <= arr[i - 1][1] && arr[i][0] == 1) {
                    p = 0;
                    while (p < n && flag != 0) {
                        if (t[p] != 0) {
                            if (arr[i][2] - arr[i - 1][2] <= 45 && arr[i][2] - t[p] >= 0) {
                                arr[i][1] = 0;
                                t[p] = 0;
                                flag--;
                                break;
                            } else if (arr[i][2] - t[p] > 45 && arr[i][2] - t[p] >= 0) {
                                t[p] = 0;
                                flag--;
                                continue;
                            }
                        }
                        p++;
                    }
                }
            }
            System.out.println("第几次：" + (i + 1) + ",price:" + arr[i][1]);
            price += arr[i][1];
        }
        System.out.println(price);
        in.close();
    }
}
