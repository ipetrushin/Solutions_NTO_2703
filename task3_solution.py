n = int(input())
columns = list(map(int, input().split()))
height = max(columns)

map1 = [[0 for i in range(n)] for j in range(height)]
map2 = [[0 for i in range(n)] for j in range(height)]

for i in range(n):
    for j in range(columns[i]):
        map1[j][i] = 1
        map2[j][i] = 1

for i in range(height):
    water = False
    for j in range(n):
        if map1[i][j] == 1:
            water = True
            continue
        if map1[i][j] == 0 and water:
            map1[i][j] = 2

for i in range(height):
    water = False
    for j in range(n - 1, -1, -1):
        if map2[i][j] == 1:
            water = True
        if map2[i][j] == 0 and water:
            map2[i][j] = 2

s = 0

for i in range(height):
    for j in range(n):
        if map1[i][j] == 2 and map2[i][j] == 2:
            s += 1

print(s*10)
