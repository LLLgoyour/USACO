import java.io.*;
import java.util.*;

public class alibi {

    static int g, n;
    static int[] parent, rank;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        g = Integer.parseInt(line[0]);
        n = Integer.parseInt(line[1]);
        int[][] grazings = new int[g][3];
        int[][] alibis = new int[n][3];
        for (int i = 0; i < g; i++) {
            line = br.readLine().split(" ");
            grazings[i][0] = Integer.parseInt(line[0]);
            grazings[i][1] = Integer.parseInt(line[1]);
            grazings[i][2] = Integer.parseInt(line[2]);
        }
        for (int i = 0; i < n; i++) {
            line = br.readLine().split(" ");
            alibis[i][0] = Integer.parseInt(line[0]);
            alibis[i][1] = Integer.parseInt(line[1]);
            alibis[i][2] = Integer.parseInt(line[2]);
        }
        parent = new int[g];
        rank = new int[g];
        for (int i = 0; i < g; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        for (int i = 0; i < g; i++) {
            for (int j = i + 1; j < g; j++) {
                int dx = grazings[i][0] - grazings[j][0];
                int dy = grazings[i][1] - grazings[j][1];
                int dt = grazings[j][2] - grazings[i][2];
                if (dx * dx + dy * dy <= dt * dt) {
                    mergeSets(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean innocent = true;
            for (int j = 0; j < g; j++) {
                int dx = alibis[i][0] - grazings[j][0];
                int dy = alibis[i][1] - grazings[j][1];
                int dt = grazings[j][2] - alibis[i][2];
                if (dx * dx + dy * dy <= dt * dt && findSet(j) == j) {
                    innocent = false;
                    break;
                }
            }
            if (innocent) {
                count++;
            }
        }
        pw.println(count);
        pw.flush();
    }

    static int findSet(int i) {
        if (parent[i] == i) {
            return i;
        }
        parent[i] = findSet(parent[i]);
        return parent[i];
    }

    static void mergeSets(int i, int j) {
        int pi = findSet(i);
        int pj = findSet(j);
        if (pi != pj) {
            if (rank[pi] < rank[pj]) {
                parent[pi] = pj;
            } else if (rank[pi] > rank[pj]) {
                parent[pj] = pi;
            } else {
                parent[pi] = pj;
                rank[pj]++;
            }
        }
    }
}
