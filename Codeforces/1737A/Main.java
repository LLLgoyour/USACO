import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(in.readLine());
        int n = 0, k = 0;
        while (number > 0) {
            // input total number of letters and number of letters in a group
            String[] s = in.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            k = Integer.parseInt(s[1]);
            String str = in.readLine();
            // record the number of each letter
            int[] letterCount = new int[25];
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                int index = c - 'a';
                letterCount[index]++;
            }
            // do MEX function
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < (n / k); j++) {
                    if (letterCount[j] == 0) {
                        char c = (char) (j + 97);
                        sb.append(c);
                        break;
                    } else {
                        letterCount[j]--;
                    }
                    if (j == (n / k - 1)) {
                        char c = (char) (j + 98);
                        sb.append(c);
                    }
                }
            }
            System.out.println(sb.toString());
            number--;
        }
    }
}