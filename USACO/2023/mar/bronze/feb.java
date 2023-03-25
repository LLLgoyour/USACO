import java.io.*;
import java.util.*;

public class feb {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        // Step 1: Count the number of B's and E's in the input string
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        int B_count = 0, E_count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'B') {
                B_count++;
            } else if (s.charAt(i) == 'E') {
                E_count++;
            }
        }

        // Step 2 and 3: Replace each 'F' in the input string with a 'B' or 'E',
        // and count the number of BB's and EE's in the modified string
        Set<Integer> excitementLevels = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'F') {
                // Replace 'F' with 'B'
                int count_BB = 0, count_EE = 0;
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(i, 'B');
                String modifiedS = sb.toString();
                for (int j = 0; j < n - 1; j++) {
                    if (modifiedS.substring(j, j + 2).equals("BB")) {
                        count_BB++;
                    }
                }
                // Replace 'F' with 'E'
                sb.setCharAt(i, 'E');
                modifiedS = sb.toString();
                for (int j = 0; j < n - 1; j++) {
                    if (modifiedS.substring(j, j + 2).equals("EE")) {
                        count_EE++;
                    }
                }
                // Calculate the excitement level for the modified string, and add
                // it to
                excitementLevels.add(B_count - count_BB + E_count - count_EE);
            }
        }

        // Step 4
        List<Integer> sortedLevels = new ArrayList<Integer>(excitementLevels);
        Collections.sort(sortedLevels);
        pw.println(sortedLevels.size());
        for (int level : sortedLevels) {
            pw.println(level);
        }
        pw.close();
    }
}
