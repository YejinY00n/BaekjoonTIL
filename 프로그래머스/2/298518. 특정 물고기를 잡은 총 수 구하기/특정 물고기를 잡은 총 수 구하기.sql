SELECT COUNT(*) AS FISH_COUNT
FROM FISH_INFO AS fi JOIN FISH_NAME_INFO AS fni ON fi.FISH_TYPE=fni.FISH_TYPE
WHERE fni.FISH_NAME LIKE 'BASS' OR fni.FISH_NAME LIKE 'SNAPPER'