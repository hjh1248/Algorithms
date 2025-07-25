x = int(input())

for i in range(1, x+1):
    N, P, B = list(map(int, input().strip().split()))
    array = list(map(int, input().strip().split()))
    max = 0
    for number in range(1, 101):
        cost = 0
        for people in array:
            if people >= number:
                cost += number * B
            else:
                cost += P
        if cost > max:
            max = cost
    print(f"#{i} {max}")