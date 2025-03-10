N, L, D = map(int, input().split())
able = D
time = (L + 5)
callTime = able
cnt = 0
while True:
  if (cnt == N):
    break
  if (time - 5 <= callTime < time):
    break
  elif (callTime < time - 5):
    callTime += able
  else:
    time += (L + 5)
    cnt += 1
  
print(callTime)