-- 코드를 입력하세요
SELECT *
FROM FOOD_PRODUCT
WHERE PRICE IN (
    SELECT MAX(PRICE)
    FROM FOOD_PRODUCT
    );


# SELECT *
# FROM FOOD_PRODUCT
# ORDER BY PRICE DESC
# LIMIT 1;