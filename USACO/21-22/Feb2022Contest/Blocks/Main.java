import java.io.*;
import java.util.*;

public class Main {
    static String [] block;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        block = new String[4];
        for(int i = 0; i < 4; i++)
        {
            block[i] = br.readLine();
        }
        for(int i = 0; i < n; i++)
        {
            String word = br.readLine();
            if(check(word))
        {
            System.out.println("YES");
        }
        else
            System.out.println("NO");
        }
    }
    public static boolean check(String s)
    { 
        boolean[] flag = new boolean[4];
        int ans = 0;
        for(int j = 0; j < s.length(); j++)
        {
            boolean star = false;
            for(int i = 0; i < 4; i++)
            {
                int pos = block[i].indexOf(s.charAt(j));
                if(pos >= 0 && flag[i] == false)
            {
                flag[i]=true;
                star = true;
                break;
            }
        }
        if(! star)
        {
            return false;
        }
    }
    return true;
    }
}