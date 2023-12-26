// https://leetcode.com/problems/number-of-provinces/

class Solution {
    boolean[] vis = new boolean[200];

    public int findCircleNum(int[][] isConnected) {
        int cons = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!vis[i]) {
                dfs(isConnected, i);
                cons++;
            }
        }
        return cons;
    }

    void dfs(int[][] isConnected, int n) {
        if (vis[n]) {
            return;
        }
        vis[n] = true;
        for (int i = 0; i < isConnected[n].length; i++) {
            if (isConnected[n][i] == 1) {
                dfs(isConnected, i);
            }
        }
    }
}