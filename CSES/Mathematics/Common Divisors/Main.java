import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        br.close();

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }

        int maxGCD = findMaxGCD(numbers, n);
        System.out.println(maxGCD);
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