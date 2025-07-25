a = int(input())

for i in range(1, a+1):
    answer = 0
    array = input().split( )
    for j in array:
        if int(j)%2==1:
            answer += int(j)
    print("#%d"%i + " %d"%answer)