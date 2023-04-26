-- 코드를 입력하세요
SELECT CONCAT('/home/grep/src/', T1.BOARD_ID, '/', T2.FILE_ID, T2.FILE_NAME, T2.FILE_EXT) AS FILE_PATH
FROM USED_GOODS_BOARD AS T1
    JOIN USED_GOODS_FILE AS T2
        ON T1.BOARD_ID = T2.BOARD_ID
WHERE VIEWS = (
    SELECT MAX(VIEWS)
    FROM USED_GOODS_BOARD
    )
ORDER BY FILE_ID DESC;