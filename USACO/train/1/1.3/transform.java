
/*
ID: lllgoyo2
LANG: JAVA
TASK: transform
*/
import java.io.*;

public class transform {
    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("transform.in"));
        PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));

        int n = Integer.parseInt(fin.readLine());
        char[][] matriz = new char[11][11];
        char[][] modificada = new char[11][11];
        char[][] temp = new char[11][11];

        for (int i = 0; i < n; i++) {
            String line = fin.readLine();
            for (int j = 0; j < n; j++) {
                matriz[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            String line = fin.readLine();
            for (int j = 0; j < n; j++) {
                modificada[i][j] = line.charAt(j);
            }
        }

        if (estaRotada90(matriz, modificada, n)) {
            fout.println(1);
        } else if (estaRotada180(matriz, modificada, n)) {
            fout.println(2);
        } else if (estaRotada270(matriz, modificada, n)) {
            fout.println(3);
        } else if (esEspejo(matriz, modificada, n)) {
            fout.println(4);
        } else if (esCombinada(matriz, modificada, temp, n)) {
            fout.println(5);
        } else if (noRotada(matriz, modificada, n)) {
            fout.println(6);
        } else {
            fout.println(7);
        }

        fout.close();
        fin.close();
    }

    static boolean estaRotada90(char[][] matriz, char[][] modificada, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (modificada[j][n - 1 - i] != matriz[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean estaRotada180(char[][] matriz, char[][] modificada, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (modificada[n - 1 - i][n - 1 - j] != matriz[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean estaRotada270(char[][] matriz, char[][] modificada, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (modificada[n - 1 - j][i] != matriz[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean noRotada(char[][] matriz, char[][] modificada, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (modificada[i][j] != matriz[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean esEspejo(char[][] matriz, char[][] modificada, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (modificada[j][n - 1 - i] != matriz[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean esCombinada(char[][] matriz, char[][] modificada, char[][] temp, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[j][n - 1 - i] = matriz[j][i];
            }
        }
        boolean combinada = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (modificada[j][n - 1 - i] != temp[i][j]) {
                    combinada = false;
                }
            }
        }

        if (combinada) {
            return true;
        } else {
            combinada = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (modificada[n - 1 - i][n - 1 - j] != temp[i][j]) {
                        combinada = false;
                    }
                }
            }

            if (combinada) {
                return true;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (modificada[n - 1 - j][i] != temp[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}