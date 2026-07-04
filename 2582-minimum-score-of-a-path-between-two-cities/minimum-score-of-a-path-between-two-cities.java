import java.util.*;

class Solution {

    private int minScore = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {

        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int dist = road[2];

            graph[u].add(new int[]{v, dist});
            graph[v].add(new int[]{u, dist});
        }

        boolean[] visited = new boolean[n + 1];

        dfs(1, graph, visited);

        return minScore;
    }

    private void dfs(int node, List<int[]>[] graph, boolean[] visited) {

        visited[node] = true;

        for (int[] edge : graph[node]) {

            int next = edge[0];
            int dist = edge[1];

            minScore = Math.min(minScore, dist);

            if (!visited[next]) {
                dfs(next, graph, visited);
            }
        }
    }
}