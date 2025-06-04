M = input()

a = M.count('=')
b = M.count('-')
c = M.count('lj')
d = M.count('nj')
e = M.count('dz=')

l = len(M)
print(l - a - b - c - d - e)