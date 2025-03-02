import sys



line = sys.stdin.readline().strip().split(' ')
while (line[0] != '0'):

  N = int(line[0])

  numberArr = line[1:]

  last = 0;

  for i in range(N):
    if (int(numberArr[i]) == last): continue
    else:
      last = int(numberArr[i])
      print(numberArr[i], end=' ')

  print("$")
  
  line = sys.stdin.readline().strip().split(' ')

# 오늘의 상식 : line = sys.stdin.readline().strip().split(' ')으로 한 줄을 배열로 받아올 수 있다~