class Solution:
    def countServers(self, n: int, logs: List[List[int]], x: int, queries: List[int]) -> List[int]:
        logs.sort(key=lambda item: item[1])
        
        indexed_queries = []
        for i in range(len(queries)):
            indexed_queries.append([queries[i], i])
            
        indexed_queries.sort()
        
        ans = [0] * len(queries)
        server_counts = [0] * (n + 1)
        active_servers = 0
        
        left = 0
        right = 0
        num_logs = len(logs)
        
        for q_time, original_idx in indexed_queries:
            window_start = q_time - x
            window_end = q_time
            
            while right < num_logs and logs[right][1] <= window_end:
                server_id = logs[right][0]
                if server_counts[server_id] == 0:
                    active_servers += 1
                server_counts[server_id] += 1
                right += 1
                
            while left < num_logs and logs[left][1] < window_start:
                server_id = logs[left][0]
                server_counts[server_id] -= 1
                if server_counts[server_id] == 0:
                    active_servers -= 1
                left += 1
                
            ans[original_idx] = n - active_servers
            
        return ans
