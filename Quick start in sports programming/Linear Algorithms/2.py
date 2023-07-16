n = input()
alles = [int(x) for x in input().split()]
maxi = alles[0]
idx = 0
for i in range(1,len(alles)):
    if alles[i]>maxi:
        maxi = alles[i]
        idx = i
print(idx+1)