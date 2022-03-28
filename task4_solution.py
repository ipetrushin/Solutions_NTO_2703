to_use = set(input().split())

reactions = []

while True:
    try:
        data = input().split('=')
    except Exception:
        break
    data0 = data[0].split(' ')
    data1 = data[1].split(' ')
    reactions.append([data0, data1])

prev = 0

while len(to_use) != prev:
    prev = len(to_use)
    for i in range(len(reactions)):
        for chem in reactions[i][0]:
            if chem not in to_use:
                break
        else:
            for chem in reactions[i][1]:
                to_use.add(chem)

to_use = sorted(to_use)

for chem in to_use:
    print(chem, end=" ")
