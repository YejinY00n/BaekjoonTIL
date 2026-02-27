from collections import deque

def solution(arr):
    st = deque()
    
    for n in arr:
        if(len(st) != 0 and st[-1] == n):
            continue
        st.append(n)
    
    return list(st)