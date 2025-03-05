N, A, B = map(int, input().split())

isBus = True
anyt = False
if B - N >= 0:
  if (B == A):
    anyt = True
  elif (B < A):
    isBus = False


if anyt:
  print("Anything")
else:
  if isBus:
    print("Bus")
  else:
    print("Subway")
