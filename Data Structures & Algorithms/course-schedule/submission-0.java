class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // create an adjacency list
        Map<Integer, List<Integer>> adjListMap = new HashMap<>();
        int[] visited = new int[numCourses];
        int[] pathVisited = new int[numCourses];
        boolean isCycle = true;

        for (int[] pair : prerequisites) {
            int preReq = pair[1];
            int courseToTake = pair[0];
            adjListMap
            .computeIfAbsent(preReq, k -> new ArrayList<>())
            .add(courseToTake);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                isCycle = dfsCheckCycle(i, adjListMap, visited, pathVisited);
            }
            if (isCycle) {
                break;
            }
        }

        return !isCycle;
    }

    private boolean dfsCheckCycle(int node, Map<Integer, List<Integer>> adjListMap, int[] visited,
    int[] pathVisited) {
        visited[node] = 1;
        pathVisited[node] = 1;

        for (int neighbour : adjListMap.getOrDefault(node, new ArrayList<>())) {
            // if the node hasn't been visited
            if (visited[neighbour] == 0) {
                boolean isCycle = dfsCheckCycle(neighbour, adjListMap, visited, pathVisited);
                if (isCycle) {
                    return true;
                }
            } else if (pathVisited[neighbour] == 1) { // visited on the same path
                return true;
            }
        }

        // backtracking
        pathVisited[node] = 0;
        return false;
    }
}
