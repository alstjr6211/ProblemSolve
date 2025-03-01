string = input()

sum = 0

star_index = 0;

for i in range(len(string) - 1):
  if (string[i] == '*'):
    star_index = i;
  else:

    if (i % 2 == 0):
      sum += int(string[i])
    else:
      sum += int(string[i]) * 3

m = int(string[12])

check = (10 - m) % 10

for i in range(10):
  count = sum
  if (star_index % 2 == 0):
    count += i
  else:
    count += i * 3

  if (count % 10 == check):
    print(i)
    break

