SELECT m.member_name AS MEMBER_NAME, r.review_text AS REVIEW_TEXT,
DATE_FORMAT(r.review_date, "%Y-%m-%d") AS REVIEW_DATE
FROM MEMBER_PROFILE AS m JOIN REST_REVIEW AS r ON m.member_id = r.member_id
WHERE m.member_id IN (
    SELECT member_id
    FROM REST_REVIEW
    GROUP BY member_id
    HAVING count(*) = (
        SELECT count(*)
        FROM REST_REVIEW
        GROUP BY member_id
        ORDER BY count(*) DESC
        LIMIT 1
    )
)
ORDER BY r.review_date ASC, r.review_text ASC;