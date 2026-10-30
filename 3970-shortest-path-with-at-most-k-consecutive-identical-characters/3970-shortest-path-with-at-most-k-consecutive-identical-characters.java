import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }
        int[][] minCost = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minCost[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0];
            int u = current[1];
            int run = current[2];

            if (u == n - 1) return cost;
            if (cost > minCost[u][run]) continue;

            for (int[] neighbor : graph[u]) {
                int v = neighbor[0];
                int weight = neighbor[1];

                int nextRun = (labels.charAt(u) == labels.charAt(v)) ? run + 1 : 1;

                if (nextRun <= k && cost + weight < minCost[v][nextRun]) {
                    minCost[v][nextRun] = cost + weight;
                    pq.offer(new int[]{cost + weight, v, nextRun});
                }
            }
        }
        return -1;
    }
}
