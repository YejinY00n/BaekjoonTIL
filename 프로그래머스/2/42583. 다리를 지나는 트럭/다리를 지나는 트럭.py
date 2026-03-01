from collections import deque

def solution(bridge_length, weight, truck_weights):
    weightQ = deque()      # 다리를 건너는 트럭의 무게
    passedQ = deque()      # 다리를 건너는 트럭의 이동 경과
    time = 0
    totalTruck = len(truck_weights)
    passedTruck = 0
    
    while(passedTruck != totalTruck):
        # 맨앞 트럭 다리 빠져나가기
        if(len(passedQ) != 0):
            p = passedQ[0]
            if(p == bridge_length):
                passedQ.popleft()
                weightQ.popleft()
                passedTruck += 1
        
        # 이동 (시간 경과)
        passedQ = deque(map(lambda x: x + 1, passedQ))
        time += 1
        
        # 새로 트럭 추가
        if(len(truck_weights) != 0):
            truck = truck_weights[0]
            
            # 무게 초과 or 길이 초과가 아니라면 추가
            if(len(weightQ)+1 <= bridge_length and sum(weightQ)+truck <= weight):
                truck_weights.pop(0)
                weightQ.append(truck)
                passedQ.append(1)
            
    return time