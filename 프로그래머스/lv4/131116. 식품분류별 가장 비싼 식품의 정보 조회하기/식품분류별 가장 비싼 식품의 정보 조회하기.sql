# 식품분류별 가격이 제일 비싼 식품을 선별해야 하므로
# WHERE절에서 메인쿼리와 서브쿼리를 비교연산 시 튜플의 항목을 (식품분류 & 가격)으로 구성해야 한다
SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT
WHERE (CATEGORY, PRICE) IN (
    SELECT CATEGORY, MAX(PRICE)   -- WHERE절에서 비교연산자의 대상인 튜플의 항목들을 정확하게 설정해야 한다
    FROM FOOD_PRODUCT
    GROUP BY CATEGORY
    )
HAVING CATEGORY IN ('과자', '국', '김치', '식용유')
ORDER BY MAX_PRICE DESC;