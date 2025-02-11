"""
현재 도시에서 다음 도시까지 갈 수 있는 기름이 없다면
무조건 구매

현재 도시가 다음 도시보다 싸다면
다다음 도시까지 가는 길의 오일도 구매

현재 도시가 다음 도시보다 비싸다면
다음 도시까지 가는 길의 오일만 구매

반복해서 탐색, 비싸다면 오일 구매 후 출발

"""

city = int(input())
roads = list(map(int, input().split()))
oilPrice = list(map(int, input().split()))

minPrice = oilPrice[0]
totalOil = 0

for i in range(city-1):
    totalOil += minPrice * roads[i]
    
    # 최저 기름값 업데이트
    if(oilPrice[i+1] < minPrice):
        minPrice = oilPrice[i+1]
            
print(totalOil)