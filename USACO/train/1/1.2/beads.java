
/*
ID: lllgoyo2
LANG: JAVA
TASK: beads
*/
import java.io.*;

public class beads {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

        int n = Integer.parseInt(in.readLine());
        String beads = in.readLine();
        in.close();

        int maxBeads = 0;
        for (int i = 0; i < n; i++) {
            int leftCount = countBeads(beads, i, -1);
            int rightCount = countBeads(beads, i, 1);
            maxBeads = Math.max(maxBeads, leftCount + rightCount);
        }

        out.println(maxBeads);
        out.close();
    }

    private static int countBeads(String necklace, int startIndex, int direction) {
        int count = 0;
        char color = 'w'; // Initial color is white

        int currentIndex = startIndex;
        while (count < necklace.length()) {
            int nextIndex = (currentIndex + direction + necklace.length()) % necklace.length();
            char currentColor = necklace.charAt(currentIndex);

            if (currentColor != 'w') {
                if (color == 'w') {
                    color = currentColor;
                } else if (currentColor != color) {
                    break; // Different color encountered, stop counting
                }
            }

            count++;
            currentIndex = nextIndex;
        }

        return count;
    }
}
