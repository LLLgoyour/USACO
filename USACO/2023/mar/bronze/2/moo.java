import java.util.*;
import java.io.*;

public class moo {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int t, n, c, p;
    static String[] words;
    static String[] types;
    static ArrayList<String> sentences;
    static int maxWords;

    static void solve() throws IOException {
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        words = new String[n];
        types = new String[n];
        sentences = new ArrayList<>();
        maxWords = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            words[i] = st.nextToken();
            types[i] = st.nextToken();
        }

        ArrayList<String> sentence = new ArrayList<>();
        int wordsCount = 0;
        for (int i = 0; i < n; i++) {
            if (types[i].equals("noun")) {
                if (wordsCount == 0) {
                    sentence.add(words[i]);
                    wordsCount++;
                } else if (wordsCount == 1) {
                    sentence.add(words[i]);
                    wordsCount++;
                } else {
                    sentences.add(String.join(" ", sentence) + ".");
                    maxWords = Math.max(maxWords, wordsCount);
                    sentence = new ArrayList<>();
                    sentence.add(words[i]);
                    wordsCount = 1;
                }
            } else if (types[i].equals("intransitive-verb")) {
                if (wordsCount == 1) {
                    sentence.add(words[i] + ".");
                    sentences.add(String.join(" ", sentence));
                    maxWords = Math.max(maxWords, wordsCount + 1);
                    sentence = new ArrayList<>();
                    wordsCount = 0;
                } else {
                    sentence = new ArrayList<>();
                    wordsCount = 0;
                }
            } else if (types[i].equals("transitive-verb")) {
                if (wordsCount == 2) {
                    sentence.add(words[i]);
                    wordsCount++;
                } else {
                    sentence = new ArrayList<>();
                    wordsCount = 0;
                }
            } else {
                if (wordsCount >= 3 && i < n - 1 && types[i + 1].equals("noun")) {
                    sentence.add(words[i]);
                    wordsCount++;
                } else {
                    sentence = new ArrayList<>();
                    wordsCount = 0;
                }
            }
        }
        if (wordsCount == 1) {
            sentence.add(".");
            sentences.add(String.join(" ", sentence));
            maxWords = Math.max(maxWords, wordsCount + 1);
        } else if (wordsCount == 2) {
            sentence.add(".");
            sentences.add(String.join(" ", sentence));
            maxWords = Math.max(maxWords, wordsCount + 1);
        } else if (wordsCount > 2) {
            sentences.add(String.join(" ", sentence) + ".");
            maxWords = Math.max(maxWords, wordsCount);
        }

        out.println(maxWords);
        out.println(String.join(" ", sentences));
        out.flush();
    }

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            solve();
        }

        in.close();
        out.close();
    }
}
