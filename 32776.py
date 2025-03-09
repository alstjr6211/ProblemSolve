S = int(input())
a, b, c = map(int, input().split())
F = a + b + c
if (S <= F):
  print("high speed rail")
else:
  if (S <= 240):
    print("high speed rail")
  else:
    print("flight")