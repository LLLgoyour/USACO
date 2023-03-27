import java.util.*;
import java.io.*;

public class feb {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String s = br.readLine();

        // 记录 B 和 E , F 的位置
        List<Integer> bIndices = new ArrayList<>();
        List<Integer> eIndices = new ArrayList<>();
        List<Integer> fIndices = new ArrayList<>();
        List<Integer> new_bIndices = bIndices; // after replacing F with B
        List<Integer> new_eIndices = eIndices; // after replacing F with E
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'B') {
                bIndices.add(i);
            } else if (s.charAt(i) == 'E') {
                eIndices.add(i);
            }
        }

        int distinct = 0;
        int count_BB = 0;
        int count_EE = 0;
        int count_BF = 0;
        int count_EF = 0;
        int newCount_BB = 0;
        int newCount_EE = 0;
        int f = 0;
        String sb, se;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'F') {
                // 替换 F 为 B 和 E
                f++;
                fIndices.add(i); // 记录 F 的位置, 之后循环F次在F的位置上从B替换成E
                char[] in = s.toCharArray();
                in[i] = 'B';
                sb = new String(in); // sb 为替换为F->B的字符串
                new_bIndices.add(i);
                // in[i] = 'E';
                // se = new String(in); // se 为替换为F->E的字符串
                // new_eIndices.add(i);
            }
        }
        // counting BBs and EEs in the original string.
        for (int j = 0; j < n - 1; j++) {
                if (j == 0 && s.charAt(j) == 'F') {
                    if (s.charAt(j+1) == 'B') {
                        count_BF++;
                    } else if (s.charAt(j+1) == 'E') {
                        count_EF++;
                    }
                }
                if (s.charAt(j) == 'B' && sb.charAt(j + 1) == 'B') {
                    count_BB++;
                }
                if (s.charAt(j) == 'B' && sb.charAt(j + 1) == 'F') {
                    count_BF++;
                }
                if (s.charAt(j) == 'E' && sb.charAt(j + 1) == 'E') {
                    count_EE++;
                }
                if (s.charAt(j) == 'E' && sb.charAt(j + 1) == 'F') {
                    count_EF++;
                }
            }
            distinct = count_BB + count_EE +count_BF + count_EF;
        

        // 计算新的 "BB" 和 "EE" 的个数
                for (int i = 0; i < bIndices.size() - 1; i++) {
                    if (bIndices.get(i) == i) { // counting new BBs
                        if (sb.charAt(bIndices.get(i + 1)) == 'B') {
                            newCount_BB++;
                        }
                    } // else if (bIndices.get(i) < i && bIndices.get(j + 1) > i) {
                    //     if (sb.charAt(i + 1) == 'B') {
                    //         newCount_BB++;
                    //     }
                    // }
                }
                if (bIndices.get(bIndices.size() - 1) == i) {
                    if (sb.charAt(s.length() - 1) == 'B') {
                        newCount_BB++;
                    }
                    if (sb.charAt(s.length() - 1) == 'F') {
                        count_BF++;
                    }
                }

                for (int j = 0; j < eIndices.size() - 1; j++) {
                    if (eIndices.get(j) == i) {
                        if (se.charAt(eIndices.get(j) + 1) == 'E') {
                            newCount_EE++;
                        }
                        if (se.charAt(eIndices.get(j) + 1) == 'F') {
                            count_EF++;
                        }
                    } else if (eIndices.get(j) < i && eIndices.get(j + 1) > i) {
                        if (se.charAt(i + 1) == 'E') {
                            newCount_EE++;
                        }
                        if (se.charAt(i + 1) == 'F') {
                            count_EF++;
                        }
                    }
                }
                if (eIndices.get(eIndices.size() - 1) == i) {
                    if (se.charAt(s
                }
        pw.println(distinct);
        // for (int i = 0; i < result.length; i++) {
    // if (result[i] > 0) {
    // pw.println(i);
    // }
        pw.close();
    }
}

// public class feb {
// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// PrintWriter pw = new PrintWriter(System.out);
// int n = Integer.parseInt(br.readLine());
// String s = br.readLine();
// char[] in = new char[s.length()];
// for (int i = 0; i < s.length(); i++) {
// in[i] = s.charAt(i);
// }
// int countB = 0, countE = 0, countBB = 0, countEE = 0, countBE = 0, countBF =
// 0, countEF = 0;
// for (int i = 0; i < n; i++) {
// if (in[i] == 'B') {
// countB++;
// if (i > 0 && in[i - 1] == 'B') {
// countBB++;
// } else if (i > 0 && in[i - 1] == 'F') {
// countBF++;
// }
// } else if (in[i] == 'E') {
// countE++;
// if (i > 0 && in[i - 1] == 'E') {
// countEE++;
// } else if (i > 0 && in[i - 1] == 'F') {
// countEF++;
// }
// }
// }
// int k = 0;
// int[] result = new int[n + 1];
// for (int i = 0; i <= countBB; i++) {
// int j = countBB - i;
// int minCountB = Math.max(0, i - countBF);
// int maxCountB = Math.min(countB, i + j + countBE);
// for (int countBtoCheck = minCountB; countBtoCheck <= maxCountB;
// countBtoCheck++) {
// int countEtoCheck = countB + countE - countBtoCheck;
// if (countEtoCheck >= 0 && countEtoCheck <= countE) {
// int excitement = countBB + countEE + Math.min(countBtoCheck, countEtoCheck);
// excitement += Math.min(countBF, countB - countBtoCheck) + Math.min(countEF,
// countE - countEtoCheck);
// result[excitement]++;
// }
// }
// }
// for (int i = 0; i < result.length; i++) {
// if (result[i] > 0) {
// k++;
// }
// }
// pw.println(k);
// for (int i = 0; i < result.length; i++) {
// if (result[i] > 0) {
// pw.println(i);
// }
// }
// pw.flush();
// pw.close();
// br.close();
// }
// }
