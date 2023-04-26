-- 코드를 입력하세요
SELECT CAR_ID,    
    CASE
        WHEN CAR_ID IN (
            SELECT CAR_ID
            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
            WHERE '2022-10-16' BETWEEN START_DATE AND END_DATE
            )
        THEN '대여중'
        ELSE '대여 가능'
    END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC;


# MAX()를 사용하면 서브쿼리 없이 훨씬 간결한 코드로 해결 가능!
# -> '대여중'과 '대여 가능'이 중첩되는 경우 UniCode 값이 더 큰 '대여중'을 선택!!!
# SELECT CAR_ID, 
#          MAX(IF('2022-10-16' BETWEEN START_DATE AND END_DATE, '대여중', '대여 가능')) AS AVAILABILITY
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
# GROUP BY CAR_ID
# ORDER BY CAR_ID DESC;