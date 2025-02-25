a = 0

for i in range(10):
  move = int(input())
  a += move

a %= 4

if (a == 0):
  print("N")
elif (a == 1):
  print("E")
elif (a == 2):
  print("S")
elif (a == 3):
  print("W")