def solve(a):
  if (a >= 300):
    return 1
  elif (a >= 275):
    return 2
  elif (a >= 250):
    return 3
  else:
    return 4


N = int(input())

num = list(map(int, input().split()))

for i in range(N):
  a = num[i]
  print(solve(a), end=' ')
