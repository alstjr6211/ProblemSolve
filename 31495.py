string = input()

i = len(string)

if (i < 3):
  print("CE")
else:
  if (string[0] == "\"" and string[i-1] == "\""):
    print(string[1:i-1])
  else:
    print("CE")