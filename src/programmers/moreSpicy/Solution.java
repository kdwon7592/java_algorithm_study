package programmers.moreSpicy;

import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        int[] scoville = new int[] {3, 1, 10, 2, 12, 9};

        solution(scoville, 7);
    }

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int answer = 0;

        for(int i = 0; i < scoville.length; i++) {
            priorityQueue.add(scoville[i]);
        }

        // 우선순위큐에 하나만 남을때까지 반복
        while(priorityQueue.size() > 1) {
            if (priorityQueue.peek() < K) {
                    priorityQueue.add(priorityQueue.poll() + (priorityQueue.poll() * 2));
                    answer++;
            } else {
                // 제일 작은값이 크면 answer 반환
                return answer;
            }
        }

        // 하나만 남았을 때 K보다 크거나 같으면 answer 반환
        if(priorityQueue.peek() >= K) {
            return answer;
        } else {
            return -1;
        }
    }
}