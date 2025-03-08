N = int(input())
arr = [0] * 52

string = input()
for i in range(N):
  if ('A' <= string[i] <= 'Z'):
    arr[ord(string[i]) - 65] += 1
  else:
    arr[ord(string[i]) - 71] += 1

flag = (arr[17] >= 1 and arr[14] >= 1 and arr[24] >= 1 and arr[6] >= 1 and arr[1] >= 1 and arr[8] >= 1 and arr[21] >= 1)
flag2 = (arr[43] >= 1 and arr[40] >= 1 and arr[50] >= 1 and arr[32] >= 1 and arr[27] >= 1 and arr[34] >= 1 and arr[47] >= 1)

if (flag):
  if (flag2):
    print("YeS")
  else:
    print("YES")
else:
  if (flag2):
    print("yes")
  else:
    print("NO!")