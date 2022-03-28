def dfs(row, col):
    if 0 > row > m or 0 > col > n or labirint[row][col] != 0:
        return
    labirint[row][col] = 2
    dfs(row - 1, col)
    dfs(row, col - 1)
    dfs(row, col + 1)

n, m = map(int, input().split())
labirint = [list(map(int, input().split())) for i in range(m)]

for i in range(n):
    dfs(m - 1, i)

s = 0

for i in range(m):
    for j in range(n):
        if labirint[i][j] == 0:
            s+=1
print(s)
