package programmers.immigration;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] test = new int[] {1 , 2, 3, 4, 5};
        System.out.println(solution(6, test));
    }

    public static long solution(int n, int[] times) {
        Arrays.sort(times);

        long start = 0;
        long end = Long.MAX_VALUE;
        long mid;
        long sum;
        long answer = Long.MAX_VALUE;

        while(start <= end){
            mid = (start + end) / 2;
            sum = 0;

            for(int i=0; i<times.length; i++){
                sum += mid / times[i];
                if(sum >= n)
                    break;
            }

            if(n > sum){
                start = mid + 1;
            } else{
                end = mid - 1;
                answer = Math.min(answer, mid);
            }
        }

        return answer;
    }

    /*실패한 코드*/
    public static long solution_fail(int n, int[] times) {
        HashMap<Integer, Integer> timesMap = new HashMap<>();
//        Arrays.sort(times);
        for(int i = 0; i < times.length; i++) {
            timesMap.put(times[i], 0);
        }
        Integer[] keys = timesMap.keySet().toArray(new Integer[0]);
        int max = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < keys.length-1; j++) {
                int key = keys[j];
                int afterKey = keys[j + 1];

                if(key * (timesMap.get(key) + 1) <= afterKey * (timesMap.get(afterKey) + 1)) {
                    timesMap.put(key, timesMap.get(key) + 1);
                    max = Math.max(key * (timesMap.get(key)), max);
                    break;
                }

                if(j + 1 == keys.length - 1) {
                    timesMap.put(afterKey, timesMap.get(afterKey) + 1);
                    max = Math.max(afterKey * (timesMap.get(afterKey)), max);
                }
            }

        }

        return max;
    }
}