def ccw(arr1, arr2, fixed):
  x1, y1 = arr1
  x2, y2 = arr2
  x3, y3 = fixed
  return (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3)



N = int(input())

stack = []

for i in range(N):
  a, b = map(int, input().split())
  arr = [a, b]
  stack.append(arr)


fixed = stack.pop()

width = 0;

for i in range(N - 2):
  arr1 = stack.pop()
  arr2 = stack.pop()

  T = ccw(arr1, arr2, fixed)

  width += T

  stack.append(arr2)
  


width = width / 2


print(abs(round(width, 1)))
  
# class5 2166번 문제 풀이.

# 이 문제는 CCW를 이용해서 풀면 되는 문제이다.

# CCW란? counter-clock width로, 기하학에서 다루는 가장 기초적인 알고리즘이다.

# 원래 CCW는 세 점이 시계방향으로 있는지, 반시계 방향으로 있는지 방향관계를 구해내는 알고리즘이다.

# 양수라면 시계, 음수라면 반시계 방향의 위치인데,

# CCW가 삼각형의 사선공식으로 넓이를 구하는 것과 비슷하기 때문에 넓이 공식에 이용할 수가 있다.

# 만약 N각형을 N - 2개의 삼각형으로 쪼개고 구한다고 하면, 오목이든 볼록이든 상관없이
# 오목한 블록이면 원래 구하던 넓이에 부호가 반대로 되도록 출력하기 때문에, 오히려 블록의 넓이가 빠진다.

# 따라서 CCW를 사용한다면, 보다 더 쉽게 넓이를 구할 수 있다.