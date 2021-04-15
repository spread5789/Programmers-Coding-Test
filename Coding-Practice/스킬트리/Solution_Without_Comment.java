class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            String tree = skill_trees[i].replaceAll("[^" + skill + "]", "");
            if(tree.equals("") || ((tree.charAt(0) == skill.charAt(0) && skill.contains(tree))))
                answer++;
        }
        return answer;
    }
}