from collections import deque

X = int(input())

for i in range(1, X + 1):
    n = int(input())
    array = []
    for _ in range(n):
        array.append(list(map(int, list(input().strip()))))
    queue = deque([[0, 0]])
    distance = [[float("inf")] * n for _ in range(n)]
    distance[0][0] = 0
    while queue:
        sx, sy = queue.popleft()
        arr = [[sx - 1, sy], [sx + 1, sy], [sx, sy - 1], [sx, sy + 1]]
        for nx, ny in arr:
            if 0 <= nx < n and 0 <= ny < n:
                if distance[sy][sx] + array[ny][nx] < distance[ny][nx]:
                    distance[ny][nx] = distance[sy][sx] + array[ny][nx]
                    queue.append([nx, ny])
    print(f"#{i} {distance[n - 1][n - 1]}")
