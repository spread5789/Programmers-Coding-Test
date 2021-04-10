import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        ArrayList<Integer> reserveList = new ArrayList<>();

        int max = n - lost.length;

        for (int i = 0; i < reserve.length; i++)
            reserveList.add(reserve[i]);

        for (int i = 0; i < lost.length; i++) {
            if (reserveList.contains(lost[i])) {
                reserveList.remove(reserveList.indexOf(lost[i]));
                max++;
            } else if (reserveList.contains(lost[i] - 1)) {
                reserveList.remove(reserveList.indexOf(lost[i] - 1));
                max++;
            } else if (reserveList.contains(lost[i] + 1)) {
                reserveList.remove(reserveList.indexOf(lost[i] + 1));
                max++;
            }
        }

        return max;
    }
}