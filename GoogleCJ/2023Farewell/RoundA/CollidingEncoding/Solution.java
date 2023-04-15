import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String[] mappingStr = br.readLine().split(" ");
            int[] mapping = new int[26];
            for (int i = 0; i < 26; i++) {
                mapping[i] = Integer.parseInt(mappingStr[i]);
            }

            int N = Integer.parseInt(br.readLine());
            HashSet<String> encodings = new HashSet<>();
            boolean hasCollision = false;

            for (int i = 0; i < N; i++) {
                String word = br.readLine();
                StringBuilder encoding = new StringBuilder();
                for (int j = 0; j < word.length(); j++) {
                    encoding.append(mapping[word.charAt(j) - 'A']);
                }
                if (encodings.contains(encoding.toString())) {
                    hasCollision = true;
                }
                encodings.add(encoding.toString());
            }

            String result = hasCollision ? "YES" : "NO";
            System.out.println("Case #" + t + ": " + result);
        }
        br.close();
    }
}
