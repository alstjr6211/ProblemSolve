while True:
  str = input()
  if str == "*": break

  flag = True
  for i in range(26):
    if chr(i + ord('a')) not in str:
      flag = False
      break
  
  print("Y" if flag else "N")