while True:
    try:
        n, k = map(int, input().split())
        sum = 0
        while (n // k != 0):
            sum += (n // k) * k
            n = n % k + n // k

        sum += n
        print(sum)
    except EOFError:
        break