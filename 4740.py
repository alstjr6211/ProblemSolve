while(True):
  string = input()
  if (string == "***"):
    break
  else:
    arr = list(string)
    
    arr.reverse()

    l = len(string)

    for i in range(l):
      print(arr[i], end="")

    print()