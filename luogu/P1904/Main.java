import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] l = new int[];
        int[] r = new int[];
        int[] h = new int[];
        int idx = 0;
        while(in.hasNext()) {
            String[] s = in.readLine().split(" ");
            l[idx]= s[0];
            h[idx]= s[1];
            r[idx]= s[2];
            idx++;
        }
        
    }
}
