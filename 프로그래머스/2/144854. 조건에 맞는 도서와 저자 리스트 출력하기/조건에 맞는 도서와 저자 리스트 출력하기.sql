SELECT BOOK_ID, AUTHOR_NAME, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM BOOK AS b JOIN AUTHOR AS a ON b.AUTHOR_ID = a.AUTHOR_ID
WHERE CATEGORY LIKE '경제'
ORDER BY PUBLISHED_DATE ASC;