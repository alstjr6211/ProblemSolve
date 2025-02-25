a, b, c, d, e = map(int, input().split())
g, h, i, j, k = map(int, input().split())

team_a = a * 6 + b * 3 + c * 2 + d + e * 2
team_b = g * 6 + h * 3 + i * 2 + j + k * 2

print(team_a, team_b)