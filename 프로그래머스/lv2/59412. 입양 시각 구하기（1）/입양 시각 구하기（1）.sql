-- 코드를 입력하세요
SELECT HOUR(DATETIME) AS HOUR, COUNT(*) AS COUNT
FROM ANIMAL_OUTS
GROUP BY HOUR
HAVING HOUR BETWEEN "9" AND "19"
ORDER BY HOUR ASC;


# MySQL에서는 WHERE절이 먼저 생성되기 때문에 WHERE절 내에서의 ALIAS 사용은 오류를 일으킬 가능성이 매우 높다.
# SELECT HOUR(DATETIME) AS HOUR, COUNT(*) AS COUNT
# FROM ANIMAL_OUTS
# WHERE HOUR(DATETIME) BETWEEN "9" AND "19"
# GROUP BY HOUR
# ORDER BY HOUR ASC;


# < SQL문 작성 순서 및 방식 >
# SELECT [칼럼명1], [칼럼명2], ... 혹은 [함수|조건식]
# FROM [테이블명]
# JOIN [테이블명] ON [조인 조건식]
# WHERE [조건식]
# GROUP BY [칼럼명1], [칼럼명2], ...
# HAVING [조건식]
# ORDER BY [칼럼명1] [ASC|DESC], [칼럼명2] [ASC|DESC], ...
# LIMIT [시작 행 번호] [행 개수]


# < DATE_FORMAT()의 형식지정자 >
#     ex) 2023년 8월 1일 토요일 13시 08분 07초
    
# Y : 4자리 연도
#     ex) 2023
# y : 2자리 연도
#     ex) 23
# m : 월 (숫자, 앞자리 0 포함)
#     ex) 08
# c : 월 (숫자, 앞자리 0 미포함)
#     ex) 8
# d : 일 (숫자, 앞자리 0 포함)
#     ex) 01
# e : 일 (숫자, 앞자리 0 미포함)
#     ex) 1
# H : 시간 (24시간 기준, 앞자리 0 포함)
#     ex) 13
# h : 시간 (12시간 기준, 앞자리 0 포함)
#     ex) 01
# i : 분 (앞자리 0포함)
#     ex) 08
# s : 초 (앞자리 0포함)
#     ex) 07

# M : 월 (문자, 완전형)  
#     ex) August
# b : 월 (문자, 축약형)
#     ex) Aug
# j : 일 (day of the year, 숫자, 앞자리 0 포함)
#     ex) 213
# W : 요일 (문자, 완전형)
#     ex) Saturday
# a : 요일 (문자, 축약형)
#     ex) Sat
# D : 요일 (서수형)
#     ex) 1st