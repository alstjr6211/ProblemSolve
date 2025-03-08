N = int(input())

arr = list(map(int, input().split()))

arr.sort()
sum = 0
for i in range(N):
  if (i == 0):
    sum += arr[i]
  elif (arr[i] == arr[i -1] + 1): continue
  else:
    sum += arr[i]

print(sum)