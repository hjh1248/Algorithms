T = int(input())

def fibonacci(n):
    global a
    global b
    if n == 0:
        a += 1
        return 0
    elif n == 1:
        b += 1
        return 1
    else:
        return fibonacci(n - 1) + fibonacci(n - 2)

for _ in range(T):
    N = int(input())
    a = 0
    b = 0
    fibonacci(N)

    print(a, b)