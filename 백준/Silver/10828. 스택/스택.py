"""
push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
"""

"""
스택 구현해서 입력값 처리
"""

import sys

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
        
# main
n = int(sys.stdin.readline().rstrip())
st = Stack()

for i in range(n):
    args = sys.stdin.readline().rstrip().split()
    
    if args[0] == "push":
        st.push(int(args[1]))
    
    elif args[0] == "pop":
        print(st.pop())
        
    elif args[0] == "size":
        print(st.size())
        
    elif args[0] == "empty":
        print(st.empty())
        
    elif args[0] == "top":
        print(st.top())