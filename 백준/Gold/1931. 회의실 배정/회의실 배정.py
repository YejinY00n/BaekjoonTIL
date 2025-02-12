import sys

"""
일찍 끝나는 순대로 정렬
첫번째 회의 끝나는 시간 <= 두번째 회의 끝나는 시간

## 회의 시간이 짧은 순에서 변경

# sorted()는 새로운 리스트 반환
# m[1]을 기준으로 정렬하고 같을 시, m[0]을 기준으로 한번 더 정렬 필요
"""

n = int(sys.stdin.readline())
meeting = [] # [시작, 끝]
total = 0
lastEnd = 0

for i in range(n):
    tmp = map(int, sys.stdin.readline().split())
    meeting.append(list(tmp))
    
meeting = sorted(meeting, key=lambda m:(m[1], m[0]))

for mStart, mEnd in meeting:
    if(mStart >= lastEnd):
        total += 1
        lastEnd = mEnd
        
print(total)