from collections import deque

def solution(priorities, location):
    q = deque()
    
    run = 0
    
    for p in priorities:
        q.append(p)
        
    while(len(q) != 0):
        maxP = max(q)
        nowP = q.popleft()
        
        if(nowP == maxP):
            run += 1
            if(location == 0):
                break
            else:
                location -= 1
        else:
            q.append(nowP)
            
            if(location == 0):
                location = len(q) - 1
            else:
                location -= 1
        
    
    return run