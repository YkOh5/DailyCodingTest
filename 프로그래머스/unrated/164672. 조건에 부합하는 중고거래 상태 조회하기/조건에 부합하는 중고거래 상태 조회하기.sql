SELECT BOARD_ID, WRITER_ID, TITLE, PRICE,
    CASE STATUS   -- CASE절의 평가대상을 STATUS로 정해두면 이후의 조건식들을 더 간단히 할 수 있다
        WHEN 'SALE' THEN '판매중'
        WHEN 'RESERVED' THEN '예약중'
        WHEN 'DONE' THEN '거래완료'
        ELSE '?'
    END AS STATUS
FROM USED_GOODS_BOARD
WHERE CREATED_DATE = '2022-10-05'
ORDER BY BOARD_ID DESC;


# WHERE절에서 조건식을 DATE_FORMAT()으로 쓰면, 정확성은 높아도 대용량 데이터 처리 시 처리속도가 떨어질 수 있다
# SELECT BOARD_ID, WRITER_ID, TITLE, PRICE,
#     CASE
#         WHEN STATUS = 'SALE' THEN '판매중'
#         WHEN STATUS = 'RESERVED' THEN '예약중'
#         ELSE '거래완료'
#     END AS STATUS
# FROM USED_GOODS_BOARD
# WHERE DATE_FORMAT(CREATED_DATE, '%Y-%m-%d') = '2022-10-05'
# ORDER BY BOARD_ID DESC;