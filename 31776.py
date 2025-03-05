N = int(input())
cnt = 0
for _ in range(N):
  a, b, c = map(int, input().split())
  if a >= 0 and b == c == -1:
    cnt += 1
  elif a >= 0 and b >= a and c == -1:
    cnt += 1
  elif 0 <= a <= b <= c:
    cnt += 1
print(cnt)