// https://leetcode.com/problems/all-paths-from-source-to-target/description/

class Solution {
    List<Integer> arr = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        arr.add(0);
        dfs(graph, 0);
        return ans;
    }

    void dfs(int[][] graph, int n) {
        if (n == graph.length - 1) {
            ans.add(new ArrayList<>(arr));
            return;
        }

        for (int i = 0; i < graph[n].length; i++) {
            arr.add(graph[n][i]);
            dfs(graph, graph[n][i]);
            arr.remove(arr.size() - 1);
        }
    }
}