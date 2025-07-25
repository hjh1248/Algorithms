n = int(input())

for i in range(1, n+1):
    x = int(input())
    array = list(map(int, input().strip().split()))
    max = 0
    answer = 0
    for j in reversed(array):
        if j >max:
            max = j
            continue
        answer += (max - j)
    print(f"#{i} {answer}")