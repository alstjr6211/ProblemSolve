N = int(input())
for _ in range(N):
  string = input()
  length = len(string) // 2
  if (string[length - 1] == string[length]):
    print("Do-it")
  else:
    print("Do-it-Not")