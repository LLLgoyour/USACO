/*
ID: lllgoyo2
LANG: JAVA
TASK: palsquare
*/

import java.io.*;

public class palsquare {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));

        char[] numbers = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                'I', 'J' };
        int base = Integer.parseInt(in.readLine());

        for (int i = 1; i <= 300; i++) {
            int s = i * i;
            String square = convert(s, base, numbers);
            String iterate = convert(i, base, numbers);
            String reverse = new StringBuilder(square).reverse().toString();

            if (reverse.equals(square)) {
                out.println(iterate + " " + square);
            }
        }

        out.close();
        in.close();
    }

    static String convert(int input, int b, char[] numbers) {
        StringBuilder result = new StringBuilder();

        while (input > 0) {
            int remainder = input % b;
            result.append(numbers[remainder]);
            input -= remainder;
            input /= b;
        }

        return result.reverse().toString();
    }
}
