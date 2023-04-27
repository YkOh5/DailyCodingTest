-- 코드를 입력하세요
SELECT YEAR(T1.SALES_DATE) AS YEAR, MONTH(T1.SALES_DATE) AS MONTH, T2.GENDER,
    COUNT(DISTINCT T2.USER_ID) AS USERS
FROM ONLINE_SALE AS T1
    JOIN USER_INFO AS T2
        ON T1.USER_ID = T2.USER_ID
WHERE T2.GENDER IS NOT NULL
GROUP BY YEAR, MONTH, T2.GENDER
ORDER BY YEAR ASC, MONTH ASC, T2.GENDER ASC;