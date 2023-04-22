-- 코드를 입력하세요
SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, "%Y-%m-%d") AS HIRE_YMD
FROM DOCTOR
WHERE MCDP_CD IN ("CS", "GS")
ORDER BY HIRE_YMD DESC, DR_NAME ASC;


# DATE_FORMAT 함수의 두 번째 매개변수인 형식 문자열(format string)에 따른 출력 결과
# -> %M : 월을 전체 이름으로 (January, Feburary, March...)
# -> %m : 월을 두 자리 기수로 (01, 02, 03...)
# -> %c : 월을 한 자리 기수로 (1, 2, 3...)
# -> %D : 일을 서수로 (1st, 2nd, 3rd...)
# -> %d : 일을 두 자리 기수로 (01, 02, 03...)