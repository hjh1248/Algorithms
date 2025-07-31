for i in range(1, 11):
    n = int(input())
    array = list(map(int, input().strip().split()))
    directions = [-2, -1, 1, 2]
    answer = 0
    for x in range(n):
        if x:
            low = 255
            for y in directions:
                if low > array[x] - array[x + y]:
                    low = array[x] - array[x + y]
            if low > 0:
                answer += low
    print(f"#{i} {answer}")