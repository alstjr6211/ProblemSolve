N = int(input()) * 2 + 1

M = int(input())

string = input()

start = True
cnt = 0
res = 0

i = 0

while i < M:
  c = string[i]

  if (c == 'I'):
    start = False
    cnt = 1
  else:
    if (start):
      cnt = 0
    else:
      if (i + 1 >= M):
        break
      
      if (string[i + 1] == 'O'):
        cnt = 0
        start = True
      else:
        cnt += 2
        i += 1
        if (cnt >= N):
          res += 1
  i += 1

print(res)