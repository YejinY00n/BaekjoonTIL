import sys
sys.setrecursionlimit(3000)

mapX = 0
mapY = 0

def solution(game_board, table):
    """
    게임 보드에서 빈칸의 모양을 조사 (=이동 경로, 칸 개수, 도형사이즈)
    테이블에서 블럭의 모양을 조사 (=이동 경로, 칸 개수, 도형사이즈)
    
    빈칸의 모양에 맞는 블럭의 최대 개수 (블럭 회전하면서 찾기)
    """
    
    empty = []
    blocks = []
    
    # 게임 보드 빈칸 모양 조사
    global mapX, mapY
    mapX = len(game_board)
    mapY = len(game_board[0])
    for i in range(len(game_board)):
        for j in range(len(game_board[0])):
            shape = []
            
            # 탐색 시작
            if(game_board[i][j] == 0):
                game_board[i][j] = 1
                shape.append([i, j])
                dfs(game_board, i, j, shape, 0)
                
                # 빈칸 모양 배열 저장
                min_r = min(s[0] for s in shape)
                min_c = min(s[1] for s in shape)
                normalized = []
                for r, c in shape:
                    normalized.append((r - min_r, c - min_c))
                empty.append(normalized)
                
    # 테이블 블록 모양 조사
    mapX = len(table)
    mapY = len(table[0])
    for i in range(len(table)):
        for j in range(len(table[0])):
            shape = []
            
            # 탐색 시작
            if(table[i][j] == 1):
                table[i][j] = 0
                shape.append([i, j])
                dfs(table, i, j, shape, 1)
                
                # 빈칸 모양 배열 저장
                min_r = min(s[0] for s in shape)
                min_c = min(s[1] for s in shape)
                normalized = []
                for r, c in shape:
                    normalized.append((r - min_r, c - min_c))
                blocks.append(normalized)
    
    answer = 0
    
    # 블록 비교
    for e in empty:
        
        # 1차 필터링: 블록 개수 일치
        tiles = len(e)
        filteredBlock = list(filter(lambda b: tiles==len(b), blocks))
        
        # 2차: 회전하면서 비교
        e.sort()
        
        for fb in filteredBlock:
            if(isMatch(e, fb)):
                answer += len(e)
                blocks.remove(fb)
                break;
            
    return answer

def dfs(maps, x, y, shape, target):
    global mapX, mapY
    # 하우상좌 탐색
    # 하
    if(x+1 < mapX and maps[x+1][y] == target):
        maps[x+1][y] = 1 - target
        shape.append([x+1, y])
        dfs(maps, x+1, y, shape, target)
    
    # 우
    if(y+1 < mapY and maps[x][y+1] == target):
        maps[x][y+1] = 1 - target
        shape.append([x, y+1])
        dfs(maps, x, y+1, shape, target)
        
    # 상
    if(x-1 >= 0 and maps[x-1][y] == target):
        maps[x-1][y] = 1 - target
        shape.append([x-1, y])
        dfs(maps, x-1, y, shape, target)
        
    # 좌
    if(y-1 >= 0 and maps[x][y-1] == target):
        maps[x][y-1] = 1 - target
        shape.append([x, y-1])
        dfs(maps, x, y-1, shape, target)
        
        
def isMatch(empty, block):
    tmpBlock = block
    
    for _ in range(4):
        tmpBlock = rotate(tmpBlock)
        if empty == tmpBlock:
            return True
    return False

def rotate(shape):
    rotated = [(c, -r) for r, c in shape]
    
    # 정규화
    min_r = min(r for r, c in rotated)
    min_c = min(c for r, c in rotated)
    
    # 정렬
    return sorted([(r - min_r, c - min_c) for r, c in rotated])
        
    
    