
/*
ID: lllgoyo2
LANG: JAVA
TASK: gift1
*/
import java.io.*;

public class gift1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        int n = Integer.parseInt(in.readLine());
        String[] name = new String[n];
        int[] money = new int[n];

        for (int i = 0; i < n; i++) {
            name[i] = in.readLine();
        }

        for (int i = 0; i < n; i++) {
            String giver = in.readLine();
            String[] s = in.readLine().split(" ");
            int ex = Integer.parseInt(s[0]);
            int people = Integer.parseInt(s[1]);
            if (people == 0) {
                continue;
            }

            int give = ex / people;
            int remaining = ex % people;

            for (int j = 0; j < people; j++) {
                String recipient = in.readLine();
                for (int k = 0; k < n; k++) {
                    if (recipient.equals(name[k])) {
                        money[k] += give;
                        break;
                    }
                }
            }

            for (int k = 0; k < n; k++) {
                if (giver.equals(name[k])) {
                    money[k] -= ex;
                    money[k] += remaining;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            out.println(name[i] + " " + money[i]);
        }

        in.close();
        out.close();
    }
}
