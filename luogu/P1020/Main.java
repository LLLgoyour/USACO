import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        in.close();
        int[] h = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            h[i] = Integer.parseInt(s[i]);
        }

    }

    static void sort(int l, int r, int[] h) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(l, m, h);
            sort(m + 1, r, h);
            merge(l, m, r, h);
        }
    }

    static void merge(int l, int m, int r, int[] h) {
        int[] temp = new int[h.length];
        for (int i = l; i <= r; i++) {
            temp[i] = h[i];
        }
        int i = l;
        int j = m + 1;
        int k = l;
        while (i <= m && j <= r) {
            if (temp[i] <= temp[j]) {
                h[k] = temp[i];
                i++;
            } else {
                h[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= m) {
            h[k] = temp[i];
            i++;
            k++;
        }
    }

}
