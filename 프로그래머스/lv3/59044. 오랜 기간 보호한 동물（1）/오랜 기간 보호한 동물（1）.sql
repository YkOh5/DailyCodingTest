-- 코드를 입력하세요
SELECT T1.NAME, T1.DATETIME
FROM ANIMAL_INS AS T1
    LEFT JOIN ANIMAL_OUTS AS T2
        ON T1.ANIMAL_ID = T2.ANIMAL_ID
WHERE T2.DATETIME IS NULL
ORDER BY T1.DATETIME ASC
LIMIT 3;