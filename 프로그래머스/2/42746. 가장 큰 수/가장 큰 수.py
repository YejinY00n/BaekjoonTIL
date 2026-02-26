def solution(numbers):
    nums = [str(n) for n in numbers]
    
    # 만약 모두 0이라면
    if(len(set(nums))==1 and "0" in set(nums)):
        return "0"
    
    # 최대 원소 길이가 3자리, 문자열 사전 비교
    nums.sort(key=lambda n:n*3, reverse=True)
    
    answer = "".join(nums)
    
    return answer