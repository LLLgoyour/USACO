import java.io.*;

public class Pareidolia {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String s = br.readLine();
        int left = 0, right = 5, pointer, count = 0, bessieCount = 0, result = 0;
        char[] chars = s.toCharArray(); // store the string with out characters other than b,e,s,i
        // store the index of the location when finds a bessie?
        ArrayList<Integer> bessieIndex = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) { // 在这里把不是b,e,s,i的字符去掉
            if (s.charAt(i) == 'b' || s.charAt(i) == 'e' || s.charAt(i) == 's' || s.charAt(i) == 'i') {
                chars[i] = s.charAt(i);
            }
        }

        // 在right < s.length()的时候++，在right == s.length()的时候停止并开始left++
        while (left < right) {
            if (right == chars.length) {
                left++;
                right = left + 5;
            }
            while (right < chars.length) {
                // (need to consider there is not even one bessie?)
                for (pointer = left; pointer < right; pointer++) {
                    if (chars[pointer] == 'b' && chars[pointer + 1] == 'e' && chars[pointer + 2] == 's'
                            && chars[pointer + 3] == 's' && chars[pointer + 4] == 'i' && chars[pointer + 5] == 'e') {
                        bessieIndex.add(pointer + 5);
                        // if there is always a same-position bessie
                        // then record the position of the bessie
                        // skip the index of bessie every time
                        // and add up the ignored bessie in every loop if the left index stays still
                        pointer += 5;
                        count += 1;
                        bessieCount += 1;
                    }
                    if (bessieCount > 0) {
                        count += bessieCount;
                    }
                }
                right++;
            }
        }
        pw.println(result);
        pw.close();
    }
}
