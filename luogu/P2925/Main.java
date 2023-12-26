import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input = in.readLine().split(" ");
		int c = Integer.parseInt(input[0]);
		int h = Integer.parseInt(input[1]);
		int[] f = new int[c + 1];
		int[] v = new int[h + 1];
		for (int i = 1; i <= h; i++) {
			v[i] = Integer.parseInt(in.readLine());
		}
		in.close();
		for (int i = 1; i <= h; i++) {
			for (int j = c; j >= v[i]; j--) {
				f[j] = Math.max(f[j], f[j - v[i]] + v[i]);
			}
			if (f[c] == c) {
				System.out.println(c);
				return;
			}
		}
		System.out.println(f[c]);
	}
}