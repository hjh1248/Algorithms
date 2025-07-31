from collections import deque

N, K = list(map(int, input().strip().split()))

visited = [False] * 100001

def bfs(start, end, visited):
    if start >= end:
        return start - end
    visited[start] = 0
    queue = deque([start])
    while queue:
        v = queue.popleft()
        array = [v - 1, v + 1, v * 2]
        for i in array:
            if i == end:
                return visited[v] + 1
            if 0 <= i and i <= 100000 and not visited[i]:
                queue.append(i)
                visited[i] = visited[v] + 1
                
print(bfs(N, K, visited))
        
        
        
        