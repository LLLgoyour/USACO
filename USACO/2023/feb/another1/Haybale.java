import java.util.*;

// © 2023 Feb. LLLgoyour.

public class Haybale {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long t = in.nextLong();
        long count = 0;
        int nextDelivery = 0;
        long haybales = 0;

        long[][] deliveries = new long[n][2];
        for (int i = 0; i < n; i++) {
            deliveries[i][0] = in.nextLong();
            deliveries[i][1] = in.nextLong();
        }

        for (int i = 0; i <= t; i++) {
            if (nextDelivery < n && i == deliveries[nextDelivery][0]) {
                haybales += deliveries[nextDelivery][1];
                nextDelivery++;
            }

            if (haybales > 0) {
                haybales--;
                count++;
            }

            if (i >= t && nextDelivery == n) {
                break;
            }
        }
        System.out.println(count);
    }
}