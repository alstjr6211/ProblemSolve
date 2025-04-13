M, N = map(int, input().split())

six = []
one = []

for i in range(N):
  a, b = map(int, input().split())
  six.append(a)
  six.append(b * 6)
  one.append(b)

six.sort()
one.sort()

ans = 0

six_cnt = M // 6
one_cnt = M % 6

ans += six_cnt * six[0]
if (one_cnt * one[0] > six[0]):
  ans += six[0]
else :
  ans += one_cnt * one[0]

print(ans)

