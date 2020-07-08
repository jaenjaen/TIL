def getSum(data):
    result = 0
    for i in data:
        result+=i
    return result

def getMean(data):
    return getSum(data)//len(data)

def getMax(data):
    maxD = data[0]
    for d in data[1:]:
        if maxD < d:
            maxD = d
    return maxD

def getMin(data):
    minD = data[0]
    for d in data[1:]:
        if minD > d:
            minD = d
    return minD

def getTwoSum(num2,num1=1): #num1이 큰 값이 왔을 때
    total=0
    if num1>num2:
        num1,num2 = num2,num1
    for i in range(num1, num2+1):
        total +=i
    return total
