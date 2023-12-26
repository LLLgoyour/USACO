/*
ID: lllgoyo2
LANG: JAVA
TASK: namenum
*/

import java.io.*;

public class namenum {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        BufferedReader in = new BufferedReader(new FileReader("namenum.in"));
        BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));

        String id = in.readLine();
        boolean found = false;
        String name;

        while ((name = dict.readLine()) != null) {
            if (name.length() == id.length()) {
                StringBuilder number = new StringBuilder();

                for (int i = 0; i < name.length(); i++) {
                    if (name.charAt(i) == 'Q' || name.charAt(i) == 'Z') {
                        continue;
                    }

                    if (name.charAt(i) < 'Q') {
                        number.append((char) (((name.charAt(i) - 'A') / 3) + '2'));
                    } else {
                        number.append((char) (((name.charAt(i) - 'Q') / 3) + '7'));
                    }
                }

                if (!number.toString().equals(id)) {
                    continue;
                }

                found = true;
                out.println(name);
            }
        }

        if (!found) {
            out.println("NONE");
        }

        out.close();
        in.close();
        dict.close();
    }
}
