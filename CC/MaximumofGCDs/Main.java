import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int[] GCD = new int[n];
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(s[j]);
            }
            for (int j = 0; j < n; j++) {
                int[] temp = Arrays.copyOfRange(arr, 0, j + 1);
                GCD[j] = findMaxGCD(temp, temp.length);
            }
            System.out.println(Arrays.toString(GCD));
        }
    }

    public static int findMaxGCD(int[] numbers, int n) {
        int maxNumber = Arrays.stream(numbers).max().getAsInt();
        int[] count = new int[maxNumber + 1];

        for (int num : numbers) {
            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    count[i]++;
                    if (i != num / i) {
                        count[num / i]++;
                    }
                }
            }
        }

        for (int i = maxNumber; i >= 1; i--) {
            if (count[i] > 1) {
                return i;
            }
        }

        return 1;
    }
}
