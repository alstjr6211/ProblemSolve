T = int(input())

for i in range(T):
  N, C = map(int, input().split())

  if (N % C == 0):
    print(N // C)
  else:
    print(N // C + 1)