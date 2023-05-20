package AtCoder.TOYOTA_3022023_2.A_Attack;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long a = Long.parseLong(input[0]);
        long b = Long.parseLong(input[1]);
        long c = calculateAttacks(a, b);
        System.out.println(c);
    }

    public static long calculateAttacks(long stamina, long attack) {
        return (stamina + attack - 1) / attack;
    }
}
