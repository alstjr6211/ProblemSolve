N = int(input())

arr = [0] * N

for i in range(N):
  arr[i] = int(input())
rMAX = 0
lMAX = 0
res_left = 0
res_right = 0
for i in range(N):
  if (arr[i] > lMAX):
    lMAX = arr[i]
    res_left += 1

for i in range(N - 1, -1, -1):
  if (arr[i] > rMAX):
    rMAX = arr[i]
    res_right += 1

print(res_left)
print(res_right)