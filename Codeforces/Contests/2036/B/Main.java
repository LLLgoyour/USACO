import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    static final int N = 200010;
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            Map<Integer, Integer> mp = new HashMap<>();
            for (int i = 1; i <= m; i++) {
                st = new StringTokenizer(br.readLine());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                mp.put(b, mp.getOrDefault(b, 0) + c);
            }

            List<Map.Entry<Integer, Integer>> tmp = new ArrayList<>(mp.entrySet());
            tmp.sort((A, B) -> B.getValue() - A.getValue());

            long res = 0;
            for (int i = 0, j = 0; i < n && j < tmp.size(); i++, j++) {
                res += tmp.get(j).getValue();
            }

            out.println(res);
        }

        out.flush();
    }
}