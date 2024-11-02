import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
    static final int MAX_SIZE = 777;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int matrixSize = Integer.parseInt(br.readLine());

        Vector<Vector<Integer>> matrixA = new Vector<>(MAX_SIZE);
        Vector<Vector<Integer>> matrixB = new Vector<>(MAX_SIZE);
        Vector<Integer> tempArr = new Vector<>(MAX_SIZE);

        for (int i = 0; i < MAX_SIZE; i++) {
            matrixA.add(new Vector<>(MAX_SIZE));
            matrixB.add(new Vector<>(MAX_SIZE));
            for (int j = 0; j < MAX_SIZE; j++) {
                matrixA.get(i).add(0);
                matrixB.get(i).add(0);
            }
            tempArr.add(0);
        }

        init(matrixA, matrixSize, br);
        process(matrixA, matrixB, tempArr, matrixSize);
        int answer = result(matrixB, matrixSize);

        out.println(answer);
        out.flush();
    }

    static char inputCharacter(BufferedReader br) throws Exception {
        char inputChar;
        while (true) {
            inputChar = (char) br.read();
            if (inputChar == '0' || inputChar == '1') {
                break;
            }
        }
        return inputChar;
    }

    static void init(Vector<Vector<Integer>> matrixA, int size, BufferedReader br) throws Exception {
        for (int i = 1; i <= size; i++) {
            for (int j = i + 1; j <= size; j++) {
                matrixA.get(i).set(j, inputCharacter(br) == '1' ? 1 : 0);
            }
        }
    }

    static void process(Vector<Vector<Integer>> matrixA, Vector<Vector<Integer>> matrixB, Vector<Integer> tempArr,
            int size) {
        for (int i = size; i >= 1; i--) {
            tempArr.set(i, 1);
            for (int j = i + 1; j < tempArr.size(); j++) {
                tempArr.set(j, 0);
            }
            for (int j = i + 1; j <= size; j++) {
                for (int k = i + 1; k < j; k++) {
                    if (matrixB.get(k).get(j) == 1) {
                        tempArr.set(j, tempArr.get(j) ^ tempArr.get(k));
                    }
                }
                if (!tempArr.get(j).equals(matrixA.get(i).get(j))) {
                    matrixB.get(i).set(j, 1);
                    tempArr.set(j, tempArr.get(j) ^ 1);
                }
            }
        }
    }

    static int result(Vector<Vector<Integer>> matrixB, int size) {
        int result = 0;
        for (int row = 1; row <= size; row++) {
            for (int col = size; col > row; col--) {
                result += matrixB.get(row).get(col);
            }
        }
        return result;
    }
}