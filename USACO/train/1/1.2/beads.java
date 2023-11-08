
/*
ID: lllgoyo2
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class beads {
    public static void main(String[] args) throws IOException {
        BufferedReader inputFile = new BufferedReader(new FileReader("beads.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

        int numBeads = Integer.parseInt(inputFile.readLine());
        char[] beadsArray = new char[numBeads];
        int[] streaksArray = new int[numBeads];
        String beadsInput = inputFile.readLine();

        for (int i = 0; i < numBeads; i++) {
            beadsArray[i] = beadsInput.charAt(i);
        }

        for (int i = 0; i < numBeads; i++) {
            char currentBead = beadsArray[i];
            int currentIndex = i;
            int counter = 0;
            char acceptedBead = '_';
            boolean undecided = true;

            while ((beadsArray[currentIndex] == currentBead || beadsArray[currentIndex] == 'w'
                    || beadsArray[currentIndex] == acceptedBead || undecided) && counter < numBeads) {
                if (beadsArray[currentIndex] != 'w') {
                    acceptedBead = beadsArray[currentIndex];
                    undecided = false;
                }
                currentIndex += 1;
                currentIndex %= numBeads;
                counter++;
            }
            streaksArray[i] = counter;
        }

        System.out.println(Arrays.toString(streaksArray));

        int maxStreak = 0;
        for (int i = 0; i < streaksArray.length; i++) {
            int currentStreak = streaksArray[i] + streaksArray[(i + streaksArray[i]) % numBeads];
            if (currentStreak > maxStreak) {
                maxStreak = currentStreak;
            }
        }
        if (maxStreak > numBeads) {
            maxStreak = numBeads;
        }

        output.println(maxStreak);
        output.close();
    }
}
