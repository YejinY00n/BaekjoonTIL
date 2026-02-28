from collections import deque

def solution(s):
    st = deque()
    
    for ch in s:
        if(ch == ')'):
            if(len(st) == 0):
                return False
            
            stCh = st.pop()
            
            if(stCh != '('):
                return False
        else:
            st.append(ch)
            
    if(len(st) != 0):
        return False
    
    return True