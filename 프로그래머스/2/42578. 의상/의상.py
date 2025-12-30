def solution(clothes):
    """
    종류별로 해시 맵 생성
    종류 끼리 경우의 수 구하고, 아무것도 안입는 경우(1) 제외
    """
    
    dic = {}
    
    for item in clothes:
        dic.setdefault(item[1], [])
        dic[item[1]].append(item[0])
    
    answer = 1
    for value in dic.values():
        answer *= len(value)+1
    
    # 옷이 1개인 경우 제외
    if(answer != 1):
        answer -= 1

    return answer