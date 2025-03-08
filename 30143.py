T = int(input())

for _ in range(T):
  N, A, D = map(int, input().split())
  print((2 * A + (N - 1) * D) * N // 2)