dots = [[1, 4], [9, 2], [3, 8], [11, 6]]
def solution(dots):
    answer = 0
    one = dots.pop(0)
    x = one[0]
    y = one[1]
    if (dots[0][0] - x) / (dots[0][1] - y) == (dots[2][0] - dots[1][0]) / (dots[2][1] - dots[1][1]):
        answer = 1
    if (dots[1][0] - x) / (dots[1][1] - y) == (dots[2][0] - dots[0][0]) / (dots[2][1] - dots[0][1]):
        answer = 1
    if (dots[2][0] - x) / (dots[2][1] - y) == (dots[1][0] - dots[0][0]) / (dots[1][1] - dots[0][1]):
        answer = 1
    return answer
print(solution(dots))