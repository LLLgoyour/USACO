public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder input = new StringBuilder();

        while ((line = in.readLine()) != null) {
            if (line.equals("E")) {
                break;
            }
            input.append(line);
        }

        // 进行计算和输出
        calculateElevenScores(input.toString());
        System.out.println("\n");
        calculateTwentyOneScores(input.toString());
    }

    static void calculateElevenScores(String input) {

    }

    static void calculateTwentyOneScores(String input) {
        System.out.println();
    }}

    

 

    