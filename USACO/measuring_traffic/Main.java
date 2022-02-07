import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("traffic.in"));
        PrintWriter out = new PrintWriter(new FileWriter("traffic.out"));

        

        int N = br.readLine();
        for (int i = 0; i < N; N++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String Ramp = st.nextToken(); // 闸道类型
            int [] lowerBound = st.nextToken(); // 下限
            int [i] higherBound = st.nextToken(); // 上限
        }
        /* 取上闸道车辆数量，取下闸道车辆数量
         * 上闸道后第1公里取上限减去上闸道车辆
         * 下闸道前1公里取下限减去下闸道上限，取上限减去下闸道上限
         */

        for ()
        {

            if (Ramp.equals("on")) 
            {
                
            }
        }
        out.close();
        
        
}
