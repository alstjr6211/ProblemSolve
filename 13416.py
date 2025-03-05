T = int(input())
for _ in range(T):
  N = int(input())
  res = 0
  for _ in range(N):
    a, b, c = map(int, input().split())
    maxi = 0
    maxi = max(maxi, a, b, c)
    res += maxi
  print(res)