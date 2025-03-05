N = int(input())
a = bin(N)[2:]
stra = str(a)
last = 0
for i in range(len(stra)):
  if stra[i] == '1':
    last = i
k = 32 - len(stra) + last
if (N == 1):
  k = 31
print(k)
