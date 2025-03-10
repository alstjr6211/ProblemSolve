N = int(input())
for _ in range(N):
  name = input().split()
  for i, n in enumerate(name):
    if (i == 0):
      print("god", end = "")
    else:
      print(n, end = "")
  print()

# 지금 사용한 것과 같이 name을 배열처럼 사용할 경우,
# 반복가능한(iterable) 자료구조에서는 for-loop문에 enumerate를 사용할 수 있다.
# 이는 해당 객체에서 인덱스값과, 값을 가져오는 iterator이다.