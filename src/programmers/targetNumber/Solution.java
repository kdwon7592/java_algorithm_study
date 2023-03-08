package programmers.targetNumber;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public static ArrayList<Integer> targetList = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(solution(new int[] {4, 1, 2, 1}, 4));
    }

    public static int solution(int[] numbers, int target) {
        return DFS(numbers, 0, 0, target);
    }

    public static int DFS(int[] numbers, int makeTarget, int idx, int target) {
        if(idx == numbers.length) {
            if(target == makeTarget) {
                return 1;
            } else {
                return 0;
            }
        }
        int answer = 0;

        answer += DFS(numbers, makeTarget + numbers[idx], idx + 1, target);
        answer += DFS(numbers, makeTarget - numbers[idx], idx + 1, target);

        return answer;
    }
}