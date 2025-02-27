T = int(input())

for _ in range(T):
  a, b, c =map(float, input().split())
  print("$%.2f" %round(a * b * c, 2))