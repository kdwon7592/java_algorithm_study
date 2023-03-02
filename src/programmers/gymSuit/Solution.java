package programmers.gymSuit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
//        13, [1, 2, 5, 6, 10, 12, 13], [2, 3, 4, 5, 7, 8, 9, 10, 11, 12]
        solution(13, new int[] {1, 2, 5, 6, 10, 12, 13}, new int[] {2, 3, 4, 5, 7, 8, 9, 10, 11, 12});
    }
    //n: 학생수 , lost: 체육복 잃어버린 학생, reserve: 여분있는 학생
    public static int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(reserve);

        List<Integer> newLost = new ArrayList<>(Arrays.asList(Arrays.stream(lost).boxed().toArray(Integer[]::new)));

        // 자신의 번호는 미리 없애야함
        for(int i = 0; i < reserve.length && newLost.size() > 0; i++) {
            // 자신의 번호 확인
            if (newLost.contains(reserve[i])) {
                newLost.remove(newLost.indexOf(reserve[i]));
                reserve[i] = -1;
                continue;
            }
        }

        //앞번호 먼저 없는지 확인 후 뒷번호 (앞번호 먼저 주는 것이 효율적)
        for(int i = 0; i < reserve.length && newLost.size() > 0; i++) {
            // 앞번호 확인
            if(newLost.contains(reserve[i]-1)) {
                newLost.remove(newLost.indexOf(reserve[i]-1));
                continue;
            }
            // 뒷번호 확인
            if(newLost.contains(reserve[i]+1)) {
                newLost.remove(newLost.indexOf(reserve[i]+1));
                continue;
            }
        }

        return n - newLost.size();
    }
}