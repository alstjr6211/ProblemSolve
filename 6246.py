N, Q = map(int, input().split())

arr = [0] * (N + 1)
for i in range(Q):
  I, L = map(int, input().split())
  
  while (I <= N):
    arr[I] = 1
    I += L

count = 0;
for i in range(1, N + 1):
  if (arr[i] == 0):
    count += 1

print(count)