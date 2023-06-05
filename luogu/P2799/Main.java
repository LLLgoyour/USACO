import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        in.close();
        String left = s;
        String right = "";
        int length = s.length();
        while (s.length() % 2 == 0) { // if the length of the string is even and the length of the
                                      // left string is greater than 2
            int mid = s.length() / 2;
            left = s.substring(0, mid);
            right = s.substring(mid, s.length());
            s = left;
            if (isSymmetric(left, right)) {
                length = left.length();
            } else {
                break;
            }
        }
        System.out.println(length);
    }

    static boolean isSymmetric(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int left = 0;
        int right = len2 - 1;
        while (left < len1 && right >= 0) { // compare the characters from the left and right
            if (str1.charAt(left) != str2.charAt(right)) {
                return false; // if the characters are not equal, then they are not symmetric
            }
            left++;
            right--;
        }
        return true; // if the characters are equal, then they are symmetric
    }
}
