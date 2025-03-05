N = int(input()) - 1
cnt = 0
num = 1
while(N >= 0):
  cnt += 1
  N -= 4 * cnt + num
  num += 4 * cnt
print(cnt)