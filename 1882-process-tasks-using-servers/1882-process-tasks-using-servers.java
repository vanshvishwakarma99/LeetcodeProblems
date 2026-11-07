class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];

        PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        PriorityQueue<int[]> usedServers = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) return Integer.compare(a[2], b[2]);
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        for (int i = 0; i < n; i++) {
            freeServers.add(new int[]{servers[i], i});
        }

        int currTime = 0;
        for (int j = 0; j < m; j++) {
            currTime = Math.max(currTime, j);

            if (freeServers.isEmpty()) {
                currTime = usedServers.peek()[2];
            }

            while (!usedServers.isEmpty() && usedServers.peek()[2] <= currTime) {
                int[] server = usedServers.poll();
                freeServers.add(new int[]{server[0], server[1]});
            }

            int[] bestServer = freeServers.poll();
            ans[j] = bestServer[1];

            usedServers.add(new int[]{bestServer[0], bestServer[1], currTime + tasks[j]});
        }

        return ans;
    }
}