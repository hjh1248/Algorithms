count = int(input())

array = []

for _ in range(count):
    array.append(input())

sorted_array = sorted(array, key=lambda x: (len(x), sum(int(digit) for digit in x if digit.isdigit()), x))

for i in sorted_array:
    print(i)