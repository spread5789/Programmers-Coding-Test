회고
==
문제를 보자마자 정규식이 바로 떠올랐다.   
자바는 기본적으로 replaceAll("정규식","치환문자") 로 사용할 수 있다.   
정규식은 잘 모르지만 대충은 알기에...   
정규식을 몰랐던 상태라면 아마 코드가 굉장히 길어졌지 않았을까 싶다.   
그 중 한가지 막 떠오른 방법이라면..   
   
반복문으로 문자마다 조건이 맞는지 charAt() 메소드를 사용하여 하나하나 비교하면서..   
음... 여기까지 하자.   
아무튼 재밌는 문제였다!

문제요약
==
'네오'는 사용자의 아이디를 추천해주는 프로그램을 개발하게 되었다.   
아이디에는 조건이 있는데, 이 조건을 만족시키지 못하는 아이디가 입력되었을경우   
정해진 규칙에 따라 추천아이디를 생성하라.   
   
![1](https://user-images.githubusercontent.com/73854324/113709562-997ec580-971d-11eb-8e67-8f0caf75d786.PNG)

![2](https://user-images.githubusercontent.com/73854324/113709564-9a175c00-971d-11eb-9477-5dc1e2b07267.PNG)

![3](https://user-images.githubusercontent.com/73854324/113709566-9aaff280-971d-11eb-835f-3bba2e8b30ae.PNG)

![4](https://user-images.githubusercontent.com/73854324/113709567-9aaff280-971d-11eb-95e5-becdb48bbcbd.PNG)
