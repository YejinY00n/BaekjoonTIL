from collections import deque

class Stack():
    def __init__(self):
        self.items = []
        
    def push(self, data):
        self.items.append(data)
        
    def pop(self):
        # if empty
        if self.empty():
            return -1
        else:
            return self.items.pop()
        
    def size(self):
        return len(self.items)
    
    def empty(self):
        # if empty
        if self.size() == 0:
            return 1
        else:
            return 0
        
    def top(self):
        # if empty
        if self.empty():
            return -1
        else:
            return self.items[-1]

# 스택으로 구현
def DFS(graph, nodes, startV):
    if(startV not in nodes):
        return [startV]
    
    visited = []
    stack = Stack()
    
    while(len(visited) != len(nodes)):
        visited.append(startV)
        
        # 작은 순서대로 방문
        for nearV in graph[startV][::-1]:
            if(nearV not in visited):
                stack.push(nearV)
        
        # 스택이 비어있지 않고 방문하지 않은 노드 pop
        while stack.empty() == 0:
            startV = stack.pop()
            if startV not in visited: break

        
    return visited


# 큐로 구현
def BFS(graph, nodes, startV):
    if(startV not in nodes):
        return [startV]
    
    visited = []
    queue = deque()
    
    while(len(visited) != len(nodes)):
        visited.append(startV)
        
        for nearV in graph[startV]:
            if(nearV not in visited):
                queue.append(nearV)
        
        # 큐가 비어있지 않다면
        while len(queue) != 0:
            startV = queue.popleft()
            if startV not in visited: break
            
    return visited
    

# 연결 리스트 그래프
nodes, links, startV = map(int, input().split())

graph = [[] for _ in range(nodes+1)]
linkedNodes = []                        # 간선이 존재하는 노드

for i in range(links):
    v1, v2 = map(int, input().split())
    graph[v1].append(v2)
    graph[v2].append(v1)
    
    if(v1 not in linkedNodes): linkedNodes.append(v1)
    if(v2 not in linkedNodes): linkedNodes.append(v2)
    
for v1 in linkedNodes:
    if graph[v1] is not None:
        graph[v1] = sorted(graph[v1])
    
dfsResults = DFS(graph, linkedNodes, startV)
bfsResults = BFS(graph, linkedNodes, startV)

cnt = 0
for i in dfsResults:
    if(cnt == len(dfsResults)-1):
        print(i)
    else:
        print(i, end=" ")
        cnt += 1
        
cnt = 0
for i in bfsResults:
    if(cnt == len(bfsResults)-1):
        print(i, end="")
    else:
        print(i, end=" ")
        cnt += 1