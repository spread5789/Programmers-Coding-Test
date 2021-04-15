class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {

            // 선행스킬을 제외한 다른 스킬 삭제
            String tree = skill_trees[i].replaceAll("[^" + skill + "]", "");

            // 1. 선행스킬에 들어있는 스킬들이 하나도 포함되어있지 않거나,
            // 2-1. 선행스킬의 첫글자와 tree 변수가 가지고 있는 첫글자가 같고,
            // 2-2. 선행스킬들의 문자가 tree 변수의 문자를 가지고 있을경우에만
            if(tree.equals("") || ((tree.charAt(0) == skill.charAt(0) && skill.contains(tree))))
                answer++;
        }
        return answer;
    }
}