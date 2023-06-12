import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[][] xRange = new int[n][2];
        int[][] yRange = new int[n][2];
        String[] s;
        int tempN = n; // 保存n的值
        while (tempN-- > 0) { // 使用tempN进行循环条件判断
            s = in.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int g = Integer.parseInt(s[2]);
            int k = Integer.parseInt(s[3]);
            xRange[tempN][0] = a;
            xRange[tempN][1] = a + g;
            yRange[tempN][0] = b;
            yRange[tempN][1] = b + k;
        }
        s = in.readLine().split(" ");
        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);
        in.close();
        /*
         * 每一个xRange和yRange在每个循环中，xRange[n][0]和yRange[n][0]都是最小值，xRange[n][1]和yRange[n][
         * 1]都是最大值
         * 因为从后往前输入（n--），所以判断x和y是否在范围内可以从0开始判断。
         */
        for (int i = 0; i < n; i++) {
            if (x >= xRange[i][0] && x <= xRange[i][1] && y >= yRange[i][0] && y <= yRange[i][1]) {
                System.out.println(n - i);
                return;
            }
        }
        System.out.println("-1"); // 在循环结束后输出找不到覆盖点的情况
    }
}
