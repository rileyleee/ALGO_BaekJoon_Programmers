SELECT A.FLAVOR FROM FIRST_HALF AS A, ICECREAM_INFO AS B
WHERE A.TOTAL_ORDER >=3000 AND B.INGREDIENT_TYPE = "fruit_based"
AND A.FLAVOR = B.FLAVOR
ORDER BY TOTAL_ORDER DESC