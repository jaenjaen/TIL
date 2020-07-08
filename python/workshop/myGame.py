import random as r

lotto=[]
for i in range(46):
    lotto.append(i)
    
def makeLotto(num):
    for i in range(num):
        print("게임 %d"%(i+1),r.sample(lotto,6)) #중복없음
#         print(r.choices(lotto,k=6)) #중복있음

def meanGrade(grade):
    tot = 0
    for g in grade:
        if g == 'A+':
            tot += 4.5
        elif g == 'A':
            tot += 4.3
        elif g == 'A-':
            tot += 4.0
        elif g == 'B+':
            tot += 3.5
        elif g == 'B':
            tot += 3.3
        elif g == 'B-':
            tot += 3.0
        elif g == 'C':
            tot += 2.5
        else:
            tot += 1.5
    return tot//len(grade)
