#gpt 작품품

for idx in range(1, 11):
    count = int(input())
    array = list(map(int, input().split()))

    for _ in range(count):
        max_idx = array.index(max(array))
        min_idx = array.index(min(array))
        
        if array[max_idx] - array[min_idx] <= 1:
            break

        array[max_idx] -= 1
        array[min_idx] += 1

    print(f"#{idx} {max(array) - min(array)}")