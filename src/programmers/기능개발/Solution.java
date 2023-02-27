package programmers.기능개발;

import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> compeleteDate = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        int beforeTaskCompleteDate = -1;
        int taskCount = 0;

        for(int i = 0; i < progresses.length; i++) {
            Double temp = Math.ceil(Double.valueOf(100 - progresses[i]) / Double.valueOf(speeds[i]));
            compeleteDate.add(temp.intValue());

            if(i == 0) {
                beforeTaskCompleteDate = compeleteDate.get(i);
                taskCount++;
            } else {
                if(beforeTaskCompleteDate >= compeleteDate.get(i)) {
                    taskCount++;
                } else {
                    beforeTaskCompleteDate = compeleteDate.get(i);
                    answer.add(taskCount);
                    taskCount = 1;
                }
            }
        }
        answer.add(taskCount);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}