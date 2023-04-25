-- 코드를 입력하세요
SELECT HOUR(DATETIME) AS HOUR, COUNT(*) AS COUNT
FROM ANIMAL_OUTS
WHERE HOUR(DATETIME) BETWEEN "9" AND "19"
GROUP BY HOUR
ORDER BY HOUR ASC;


# DATE_FORMAT 함수
# k : 시간 (24시간 기준, 앞자리 0 미포함)
# H : 시간 (24시간 기준, 앞자리 0 포함)
# I : 시간 (AM, PM 기준)
# i : 분
# s : 초