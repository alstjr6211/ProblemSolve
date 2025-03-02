import sys

N = int(input())

point_set = set()

cnt = 0

for i in range(N):
  x , y = map(int, input().split())
  point_set.add((x,y))

for xy in point_set:
  x1 = xy[0]
  y1 = xy[1]
  for xy in point_set:
    x2 = xy[0]
    y2 = xy[1]
    if (x1 == x2) or (y1 == y2): continue
    else:
      if (x1, y2) in point_set and (x2, y1) in point_set:
        cnt += 1

print(cnt // 4)