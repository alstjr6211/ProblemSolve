N, K = map(int, input().split())

arr = list(map(int, input().split()))
max = -10000
for i in range(N - K + 1):
  sum = 0
  for j in range(K):
    sum += arr[i + j]
  if (sum > max):
    max = sum

print(max)
