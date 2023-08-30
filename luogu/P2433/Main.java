import java.io.*;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        if (T == 1) {
            System.out.println("I love Luogu!");
        } else if (T == 2) {
            System.out.print(2 + 4 + " ");
            System.out.print(10 - 2 - 4);
        } else if (T == 3) {
            int i = 14;
            System.out.print(i / 4 + " ");
            i = i / 4 * 4;
            System.out.print(i + " " + (14 - i));
        } else if (T == 4) {
            double divided = 500.0;
            double divisor = 3.0;

            double result = divided / divisor;

            String formattedResult = String.format("%.6f", result);
            System.out.println(formattedResult);
        } else if (T == 5) {
            System.out.println((260 + 220) / (12 + 20));
        } else if (T == 6) {
            System.out.println(Math.sqrt(117));
        } else if (T == 7) {
            System.out.println("110");
            System.out.println("90");
            System.out.println("0");
        } else if (T == 8) {
            double r = 5.0;
            double pi = 3.141593;
            double para = 10 * pi;
            double area = r * pi * pi;
            double vol = 4 / 3 * pi * r * r * r;
            System.out.println(para);
            System.out.println(area);
            System.out.println(vol);
        } else if (T == 9) {
            System.out.println((((1 + (1 + 1) * 2) * 2 + 1) * 2 + 1));
        } else if (T == 10) {
            System.out.println("10");
        } else if (T == 11) {
            System.out.println("33");
        } else if (T == 12) {
            char letterM = 'M';
            int positionM = letterM - 'A' + 1;

            System.out.println(positionM);

            int position18 = 18;
            char letterAt18 = (char) ('A' + position18 - 1);

            System.out.println(letterAt18);
        } else if (T == 13) {
            double pi = 3.141593;
            double radius1 = 4;
            double radius2 = 10;

            double totalVolume = (4.0 / 3.0) * pi * (Math.pow(radius1, 3) + Math.pow(radius2, 3));

            int integerCubeEdgeLength = (int) Math.cbrt(totalVolume);

            System.out.println(integerCubeEdgeLength);
        } else if (T == 14) {
            System.out.println("113");
        }
        in.close();
    }
}
