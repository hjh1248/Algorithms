N = int(input())

array = []

for _ in range(N):
    array.append(list(map(int, input().strip().split())))

sorted_array = sorted(array, key=lambda x: (x[1], x[0]))

count = 0
last_end_time = 0

for i in sorted_array:
    if i[0] >= last_end_time:
        count += 1
        last_end_time = i[1]

print(count)
