from collections import deque

def solution(progresses, speeds):
    answer = []
    q = deque()
    
    for p in progresses:
        q.append(p)
    
    finished = 0
    
    while(len(q) != 0):
        for i in range(len(speeds)):
            q[i] += speeds[i]
        
        if(q[0] >= 100):
            while(len(q) != 0 and q[0] >= 100):
                finished +=1
                q.popleft()
                speeds.pop(0)
                
            answer.append(finished)
            finished = 0
            
    
    return answer