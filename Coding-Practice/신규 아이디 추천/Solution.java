class Solution {
    public String solution(String new_id) {

        // 1. 대문자를 소문자로 치환
        new_id = new_id.toLowerCase()

                // 2. 해당되지 않는 문자 제거
                .replaceAll("[^a-z0-9-_.]","")

                // 3. .. ~ => . 하나로
                .replaceAll("[.]+",".")

                // 4. . 처음이나 마지막이면 제거
                .replaceAll("^[.]+|[.]+$","")

                // 5. 비었다면 a로
                .replaceAll("^$","a");

        // 6. 16자 이상일 경우 15자로 맞춤 (. 가 마지막일 경우 제거)
        if(new_id.length()>15)
            new_id = new_id.substring(0,15).replaceAll("[.]$","");

        // 7. 2자 이하라면 마지막 문자를 3자가 될때까지 붙힘
        if(new_id.length()<=2)
            while(new_id.length()<3)
                new_id+=new_id.charAt(new_id.length()-1);

        return new_id;
    }
}