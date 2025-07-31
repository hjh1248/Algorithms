# 시간초과, 익은 토마토 기준으로 날짜를 기록하며 해야함 수정 필요

from collections import deque

M, N = list(map(int, input().strip().split()))

tomatos = []
for _ in range(N):
    tomatos.append(list(map(int, input().strip().split())))

def bfs(sx, sy, tomatos, M, N):
    visited = [[0]*M for _ in range(N)]
    queue = deque([[sx, sy]])
    while queue:
        x, y = queue.popleft()
        array = [[x -1, y], [x + 1, y], [x, y - 1], [x, y + 1]]
        for nx, ny in array:
            if 0<=nx<=M-1 and 0<=ny<=N-1 and not visited[ny][nx] and tomatos[ny][nx] != -1:
                visited[ny][nx] = visited[y][x] + 1
                if tomatos[ny][nx] == 1:
                    return visited[ny][nx]
                queue.append([nx, ny])
    
answer = 0

for i in range(M):
    for j in range(N):
        if tomatos[j][i] == 0:
            result = bfs(i, j, tomatos, M, N)
            if not result:
                print(-1)
                exit()
            answer = max(answer, result)
print(answer)