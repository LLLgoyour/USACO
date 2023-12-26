// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/

class Solution {
    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] indegrees = new int[m][n];
        Queue<int[]> queue = new LinkedList<>(); // BFS
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] dir : dirs) {
                    int nextI = i + dir[0];
                    int nextJ = j + dir[1];
                    if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n
                            && matrix[nextI][nextJ] < matrix[i][j]) {
                        indegrees[i][j]++;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (indegrees[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            ans++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int nextI = pos[0] + dir[0];
                    int nextJ = pos[1] + dir[1];
                    if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n
                            && matrix[nextI][nextJ] > matrix[pos[0]][pos[1]]) {
                        indegrees[nextI][nextJ]--;
                        if (indegrees[nextI][nextJ] == 0) {
                            queue.offer(new int[] { nextI, nextJ });
                        }
                    }
                }
            }
        }
        return ans;
    }
}