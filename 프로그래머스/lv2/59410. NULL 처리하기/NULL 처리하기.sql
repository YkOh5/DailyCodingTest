-- 코드를 입력하세요
SELECT ANIMAL_TYPE, 
    IFNULL(NAME, "No name") AS NAME,
    SEX_UPON_INTAKE
FROM ANIMAL_INS    
ORDER BY ANIMAL_ID;


-- NAME의 값이 NULL이 아닌 공백('')인 경우도 존재한다면 조건문을 통해서 아래와 같이 처리 가능
# SELECT ANIMAL_TYPE, 
#     CASE 
#         WHEN IFNULL(NAME, '') = '' THEN 'No name'
#         ELSE NAME
#     END,
#     SEX_UPON_INTAKE
# FROM ANIMAL_INS    
# ORDER BY ANIMAL_ID;