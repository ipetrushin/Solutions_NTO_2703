n, m = map(int, input().split())

clicks = list(map(int, input().split()))

field = [[False for i in range(n)] for j in range(n)]


for click in clicks:
    cl = click - 1
    row = cl // n
    column = cl % n
    for i in range(n):
        field[row][i] = not field[row][i]
    for i in range(n):
        if i == row:
            continue
        field[i][column] = not field[i][column]
s = 0

for row in range(n):
    for column in range(n):
        if field[row][column]:
            s += 1

print(s)
