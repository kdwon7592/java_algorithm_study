package programmers.모의고사;

import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = new int[] {1,2,3,4,5};
        int[] two = new int[] {2,1,2,3,2,4,2,5};
        int[] three = new int[] {3,3,1,1,2,2,4,4,5,5};

        int oneAnswer = 0;
        int twoAnswer = 0;
        int threeAnswer = 0;

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == one[(one.length + i) % 5]) {
                oneAnswer++;
            }

            if(answers[i] == two[(two.length + i) % 8]) {
                twoAnswer++;
            }

            if(answers[i] == three[(three.length + i) % 10]) {
                threeAnswer++;
            }
        }

        int max = Math.max(Math.max(oneAnswer, twoAnswer), threeAnswer);
        ArrayList<Integer> answer = new ArrayList<>();

        if(max == oneAnswer) {
            answer.add(1);
        }

        if(max == twoAnswer) {
            answer.add(2);
        }

        if(max == threeAnswer) {
            answer.add(3);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}