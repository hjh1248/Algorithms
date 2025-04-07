polynomial = "x"
def solution(polynomial):
    split = polynomial.split(' + ')
    x=0
    n=0
    for i in split:
        if i[-1] == 'x':
            if i[0] == 'x':
                x += 1
            else:
                x += int(i[:-1])
        else:
            n += int(i)
    if x == 0:
        answer = ''
    elif x == 1:
        answer = 'x'
    else:
        answer = f'{x}x'
    if n != 0:
        if answer == '':
            answer = f'{n}'
        else:
            answer += f' + {n}'
    return answer
print(solution(polynomial))