
/*
ID: lllgoyo2
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Beads {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("beads.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

        int numBeads = Integer.parseInt(reader.readLine());
        char[] beadsArray = new char[numBeads];
        int[] streaks = new int[numBeads];
        String beadsInput = reader.readLine();

        for (int i = 0; i < numBeads; i++) {
            beadsArray[i] = beadsInput.charAt(i);
        }

        for (int i = 0; i < numBeads; i++) {
            char bead = beadsArray[i];
            int index = i;
            int counter = 0;
            char acceptedBead = '_';
            boolean isUndecided = true;

            while ((beadsArray[index] == bead || beadsArray[index] == 'w' || beadsArray[index] == acceptedBead
                    || isUndecided) && counter < numBeads) {
                if (beadsArray[index] != 'w') {
                    acceptedBead = beadsArray[index];
                    isUndecided = false;
                }
                index += 1;
                index %= numBeads;
                counter++;
            }
            streaks[i] = counter;
        }

        System.out.println(Arrays.toString(streaks));

        int maxStreak = 0;

        for (int i = 0; i < streaks.length; i++) {
            int tmp = streaks[i] + streaks[(i + streaks[i]) % numBeads];
            if (tmp > maxStreak) {
                maxStreak = tmp;
            }
        }

        if (maxStreak > numBeads) {
            maxStreak = numBeads;
        }

        writer.println(maxStreak);
        writer.close();
    }
}