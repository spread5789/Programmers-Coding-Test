문제
==
![캡처](https://user-images.githubusercontent.com/73854324/122163352-04801180-ceb0-11eb-894c-397a538f80b6.PNG)
<br><br>
==
My SQL 에서의 IF문 사용법.   
IF(조건,참일때,거짓일때)
```
SELECT ANIMAL_ID, IF(ANIMAL_TYPE='Dog','개','개아님') AS '개 판별'
FROM ANIMAL_INS
```
![1](https://user-images.githubusercontent.com/73854324/122163636-735d6a80-ceb0-11eb-9c63-2ee68c5d85da.PNG)