// https://leetcode.com/problems/course-schedule/description/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDeg = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] tmp : prerequisites) {
            adjacency.get(tmp[1]).add(tmp[0]);
            inDeg[tmp[0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            numCourses--;
            for (int cur : adjacency.get(tmp)) {
                inDeg[cur]--;
                if (inDeg[cur] == 0) {
                    queue.add(cur);
                }
            }
        }
        return numCourses-- == 0;
    }
}