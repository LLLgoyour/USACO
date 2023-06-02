import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String s1 = br.readLine();
        int ans = 0;
        for(int i = 2; i <= s.length()-2; i+=2)
        {
            int pos = s1.indexOf(s.charAt(i));
            int t = i - 2;
            int pos1 = s1.indexOf(s.charAt(t));
            if(pos1 >= 0 && pos1 <= pos)
            {
                continue;
            }
            else
            {
                ans ++; 
            }
        }
        System.out.print(ans);
    }
}