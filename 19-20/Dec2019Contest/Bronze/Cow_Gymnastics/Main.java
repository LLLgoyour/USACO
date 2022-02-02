import java.io.*;
import java.util.*;

public class Main {
    static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("gymnastics.in"));
        PrintWriter out = new PrintWriter(new FileWriter("gymnastics.out"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readline());
        int n = Integer.parseInt(br.readLine());

        ArrayList[] list = new ArrayList[x];
        for (int i = 0; i < x; i++) {
            list[i] = new ArrayList();
        }
    }
}
