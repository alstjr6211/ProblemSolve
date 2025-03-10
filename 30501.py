N = int(input())

for _ in range(N):
  name = input()
  name_len = len(name)
  for i in range(name_len):
    if (name[i] == 'S'):
      print(name)
      break