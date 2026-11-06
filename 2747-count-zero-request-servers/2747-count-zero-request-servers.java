import java.util.Arrays;

public class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int numQueries = queries.length;
        int numLogs = logs.length;
        
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        
        int[][] indexedQueries = new int[numQueries][2];
        for (int i = 0; i < numQueries; i++) {
            indexedQueries[i][0] = queries[i];
            indexedQueries[i][1] = i;
        }
        
        Arrays.sort(indexedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] ans = new int[numQueries];
        int[] serverCounts = new int[n + 1];
        int activeServers = 0;
        
        int left = 0;
        int right = 0;
        
        for (int i = 0; i < numQueries; i++) {
            int qTime = indexedQueries[i][0];
            int originalIdx = indexedQueries[i][1];
            
            int windowStart = qTime - x;
            int windowEnd = qTime;
            
            while (right < numLogs && logs[right][1] <= windowEnd) {
                int serverId = logs[right][0];
                if (serverCounts[serverId] == 0) {
                    activeServers++;
                }
                serverCounts[serverId]++;
                right++;
            }
            
            while (left < numLogs && logs[left][1] < windowStart) {
                int serverId = logs[left][0];
                serverCounts[serverId]--;
                if (serverCounts[serverId] == 0) {
                    activeServers--;
                }
                left++;
            }
            
            ans[originalIdx] = n - activeServers;
        }
        
        return ans;
    }
}
