문제
==
![캡처](https://user-images.githubusercontent.com/73854324/116769412-d321c280-aa76-11eb-90a7-aabb7e184e43.PNG)
<br><br>
==
```
-- ID, NAME을 추출한다
SELECT ANIMAL_ID,NAME

-- ANIMAL_INS 테이블에서
FROM ANIMAL_INS

-- 단, 상태가 Sick 인 동물들만,
WHERE INTAKE_CONDITION='Sick'

-- ID 를 기준으로 오름차순한다.
ORDER BY ANIMAL_ID ASC
```