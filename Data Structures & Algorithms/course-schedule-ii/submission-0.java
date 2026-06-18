class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjListMap = new HashMap<>();

        for (int[] pair : prerequisites) {
            int preReq = pair[1];
            int courseToTake = pair[0];
            adjListMap
            .computeIfAbsent(preReq, k -> new ArrayList<>())
            .add(courseToTake);
        }

        int[] indegrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int neighbour : adjListMap.getOrDefault(i, new ArrayList<>())) {
                indegrees[neighbour]++;
            }
        }

        int[] topoSort = bfsTopoSort(adjListMap, indegrees);

        return topoSort != null ? topoSort : new int[0];
    }

    private int[] bfsTopoSort(Map<Integer, List<Integer>> adjListMap,
    int[] indegrees) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }

        int[] topoSort = new int[indegrees.length];
        int idx = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            topoSort[idx++] = curr;

            for (int neighbour : adjListMap.getOrDefault(curr, new ArrayList<>())) {
                indegrees[neighbour]--;
                if (indegrees[neighbour] == 0) {
                    q.offer(neighbour);
                }
            }
        }

        return idx == indegrees.length ? topoSort : null;
    }
}
