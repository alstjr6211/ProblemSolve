def call_cost(time, min):
  hour = int(time[0:2])
  minute = int(time[3:5])

  if (hour > 18 or hour < 6):
    return min * 5
  elif (hour > 6 and hour < 18):
    return min * 10
  elif (hour == 18):
    a = min * 10
    k = 60 - (minute + min)
    if (k < 0):
      a -= k * -5
    return a
  
  else:
    a = min * 5
    k = 60 - (minute + min)
    if (k < 0):
      a += (k * -5)
    return a
    

N = int(input())

res = 0;

for i in range(N):
  a, b = input().split()
  b = int(b)
  res += call_cost(a, b)

print(res)