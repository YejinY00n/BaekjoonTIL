from collections import deque

def solution(maps):
    maps = [list(row) for row in maps]
    st = deque()
    answer = []
    row = len(maps)
    col = len(maps[0])
    
    for i in range(row):
        for j in range(col):
            if(maps[i][j] != 'X'):
                food = 0
                food += int(maps[i][j])
                maps[i][j] = 'X'
                st.append((i, j))
                
                while(len(st) != 0):
                    x, y = st.pop()
                    
                    if(x-1 >= 0 and maps[x-1][y] != 'X'):
                        food += int(maps[x-1][y])
                        maps[x-1][y] = 'X'
                        st.append((x-1, y))
                    
                    if(x+1 < row and maps[x+1][y] != 'X'):
                        food += int(maps[x+1][y])
                        maps[x+1][y] = 'X'
                        st.append((x+1, y))
                    
                    if(y-1 >= 0 and maps[x][y-1] != 'X'):
                        food += int(maps[x][y-1])
                        maps[x][y-1] = 'X'
                        st.append((x, y-1))
                        
                    if(y+1 < col and maps[x][y+1] != 'X'):
                        food += int(maps[x][y+1])
                        maps[x][y+1] = 'X'
                        st.append((x, y+1))
                        
                answer.append(food)

    if(len(answer) == 0):
        return [-1]
    
    answer.sort()

    return answer