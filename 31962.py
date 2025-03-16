N, X = map(int, input().split())
res = -1
max_time = 0
for _ in range(N):
  a, b = map(int, input().split())
  if (a + b <= X):
    if (a > max_time):
      max_time = a
      res = a
print(res)