문제
==
![캡처](https://user-images.githubusercontent.com/73854324/119265309-2ffd3c80-bc21-11eb-825d-8bc26c3c1830.PNG)
<br><br>
==
UPPER(NAME) = NAME 값을 대문자로 변경 후 검색
LOWER(NAME) = NAME 값을 소문자로 변경 후 검색

하지만 MYSQL은 기본적으로,
VARCHAR 형식은 대,소문자를 구분하지 않는다.
VARBINARY 형식은 대,소문자를 구분한다.

또한 MYSQL 에서
show variables like 'lower_case_table_names';
를 입력하면 값을 확인할 수 있는데,
0 - 대소문자 구분 함
1 - 대소문자 구분 안함
2 - 대소문자 구분 함 (참조시에는 소문자로 변경)

윈도우는 대 소문자를 기본적으로 구분하지 않기에 의미가 없고,
UNIX 는 대 소문자를 구분하기에 적절히 사용하면 될 것이다.