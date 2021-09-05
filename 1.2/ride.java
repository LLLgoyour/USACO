
/*
ID: lllgoyo2
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {
    public static void main(String[] args) throws Exception {
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
    }
    public static void main(String[] args) 
    public int main letterToNumber(String letter) {
            int length = letter.length();
            int num = 0;
            int number = 0;
            for (int i = 0; i < length; i++) {
                char ch = letter. charAt(length - i - 1);
                num = (int)(ch - 'A' + 1 );
                num *= Math.pow(26, i);
                number += num;
                }
        }
}

