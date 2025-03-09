string = input()
N = len(string)

for i in range(N):
  if ('A' <= string[i] <= 'Z'):
    p = chr(ord(string[i]) + 32)
  else:
    p = chr(ord(string[i]) - 32)
  print(p, end='')