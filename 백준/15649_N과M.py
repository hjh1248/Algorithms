from itertools import permutations 

N, M = list(map(int, input().strip().split()))

perm = permutations(range(N + 1), M)

for i in sorted(perm):
    print(*i)