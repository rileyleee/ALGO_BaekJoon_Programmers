-- 코드를 작성해주세요
SELECT B.ITEM_ID, B.ITEM_NAME
FROM ITEM_TREE AS A, ITEM_INFO AS B
WHERE A.PARENT_ITEM_ID IS NULL
AND A.ITEM_ID = B.ITEM_ID
ORDER BY 1