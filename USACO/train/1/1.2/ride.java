
/*
ID: lllgoyo2
LANG: JAVA
TASK: ride
*/
import java.io.*;

public class ride {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        String comet = in.readLine();
        int cometMod = 1;
        int groupMod = 1;
        for (int i = 0; i < comet.length(); i++) {
            cometMod *= (comet.charAt(i) - 'A' + 1);
        }
        String group = in.readLine();
        in.close();
        for (int i = 0; i < group.length(); i++) {
            groupMod *= (group.charAt(i) - 'A' + 1);
        }
        if (cometMod % 47 == groupMod % 47) {
            out.println("GO");
        } else {
            out.println("STAY");
        }
        out.close();
    }
}
