SELECT car.car_id AS CAR_ID, car.car_type AS CAR_TYPE,
ROUND((car.daily_fee * 30 * (100 - dis.discount_rate) / 100)) as FEE
FROM (CAR_RENTAL_COMPANY_CAR AS car JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS his
      ON car.CAR_ID = his.CAR_ID)
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS dis
ON car.CAR_TYPE = dis.CAR_TYPE
WHERE (car.CAR_TYPE = '세단' OR car.CAR_TYPE = 'SUV')
AND car.CAR_ID NOT IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE <= '2022-11-30' AND END_DATE   >= '2022-11-01'
    )
AND dis.duration_type='30일 이상'
AND (car.daily_fee * 30 * (100 - dis.discount_rate) / 100) >= 500000
AND (car.daily_fee * 30 * (100 - dis.discount_rate) / 100) < 2000000
GROUP BY car.car_id
ORDER BY fee DESC, car.car_type ASC, car.car_id DESC;