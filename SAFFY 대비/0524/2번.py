x = int(input())

for i in range(1, x+1):
    N, M = list(map(int, input().strip().split()))
    array = list(map(int, input().strip().split()))

    answer = 0
    check = 0
    tmp = array[0]

    for j in range(1, len(array)):
        if array[j] > tmp:
            answer += array[j] - tmp
        else:
            check = 1
            answer += M - (tmp - array[j])
        tmp = array[j]

    if check == 1:
        answer -= M
    else:
        if array[1] > array[0]:
            a = array[1] - array[0]
        else:
            a = M - array[1] + array[0]

        if array[-1] > array[-2]:
            b = array[-1] - array[-2]
        else:
            b = M - array[-1] + array[-2]

        answer -= max(a, b)

    print(f"#{i} {answer}")