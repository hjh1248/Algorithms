from itertools import combinations

N, S = list(map(int, input().strip().split()))
array = list(map(int, input().strip().split()))
answer = 0

for i in range(1, N+1):
    com = combinations(array, i)
    for j in com:
        if sum(j) == S:
            answer += 1
print(answer)