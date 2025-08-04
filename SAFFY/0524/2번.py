x = int(input())

for i in range(1, x+1):
    N, M = list(map(int, input().strip().split()))
    array = list(map(int, input().strip().split()))

    answer = 0
    max_jump = 0
    temp_dist = 0

    for j in range(1, len(array)):

        if array[j] > array[j-1]:
            dist1 = array[j] - array[j-1]
        else:
            dist1 = M - (array[j-1] - array[j])
        answer += dist1

        if j==len(array)-1:
            continue
        
        if array[j+1] > array[j]:
            dist2 = array[j+1] - array[j]
        else:
            dist2 = M - (array[j] - array[j+1])

        if array[j+1] > array[j-1]:
            dist3 = array[j+1] - array[j-1]
        else:
            dist3 = M - (array[j-1] - array[j+1])

        max_jump = max(max_jump, dist1+dist2-dist3)

    if array[1] > array[0]:
        a = array[1] - array[0]
    else:
        a = M - array[0] + array[1]

    if array[-1] > array[-2]:
        b = array[-1] - array[-2]
    else:
        b = M - array[-2] + array[-1]

    answer -= max(a, b, max_jump)

    print(f"#{i} {answer}")