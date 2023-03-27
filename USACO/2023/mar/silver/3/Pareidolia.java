// import java.io.*;
// import java.util.*;

// public class Pareidolia {
// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// PrintWriter pw = new PrintWriter(System.out);

// String s = br.readLine();
// int left = 0, right = 5, pointer, count = 0, bessieCount = 0;
// // store the index of the location when finds a bessie
// ArrayList<Integer> bessieIndex = new ArrayList<Integer>();
// // only store b, e, s, i characters
// char[] chars = s.replaceAll("[^besi]", "").toCharArray();
// // 在right < chars.length的时候++，在right == chars.length的时候停止并开始left++
// while (left < right) {
// if (chars.length < 6) {
// break;
// }
// if (right >= chars.length) {
// left++;
// right = left + 5;
// }
// while (right <= chars.length) {
// for (pointer = left; pointer <= right - 5; pointer++) { // TO THINK: 4 OR 5?
// if (bessieIndex.size() != 0) {
// pointer = bessieIndex.get(bessieIndex.size() - 1);
// // 如果记录了bessie的位置
// // 那么pointer从最后一个bessie位置开始
// }
// if (bessieCount > 0) {
// count += bessieCount;
// }
// if (pointer + 5 < chars.length && chars[pointer] == 'b'
// && chars[pointer + 1] == 'e'
// && chars[pointer + 2] == 's'
// && chars[pointer + 3] == 's'
// && chars[pointer + 4] == 'i'
// && chars[pointer + 5] == 'e') {
// bessieIndex.add(pointer + 5);
// // if there is always a same-position bessie
// // then record the position of the bessie
// // skip the index of bessie every time
// // and add up the ignored bessie in every loop if the left index stays still
// count += 1;
// bessieCount += 1;
// }
// }
// right++;
// bessieIndex.clear();
// bessieCount = 0;
// }
// }
// pw.println(count);
// pw.close();
// }
// }