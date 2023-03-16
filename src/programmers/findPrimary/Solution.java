package programmers.findPrimary;

import java.util.*;

class Solution {
    private static HashSet<Integer> numberMix = new HashSet<>();
    public static void main(String[] args) {
        System.out.println(solution("011"));
    }
    public static int solution(String numbers) {
        boolean[] notPrimary = new boolean[10000000];
        for(int i = 2; i < 3163; i++) {
            if(notPrimary[i] == true) {
                continue;
            }
            for(int j = i + i; j < 10000000; j = j + i) {
                notPrimary[j] = true;
            }
        }

        ArrayList<Integer> primaryNum = new ArrayList<>();
        for(int i = 2; i < 10000000; i++) {
            if(notPrimary[i] == false) {
                primaryNum.add(i);
            }
        }

        for(int i = 0 ; i < numbers.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder(numbers);
            char[] tempArr = numbers.toCharArray();
            numberMix.add((int) stringBuilder.charAt(i)  - 48);

            BFS((int) stringBuilder.charAt(i)  - 48, stringBuilder.deleteCharAt(i).toString());
        }

        int answer = 0;

        Iterator<Integer> iter = numberMix.iterator();
        while(iter.hasNext()) {
            if(primaryNum.indexOf(iter.next()) > -1) {
                answer++;
            }
        }
        return answer;
    }

    public static void BFS(int index, String arr){
        for(int i = 0; i < arr.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder(arr);
            int mix = Integer.parseInt(String.valueOf(index) + String.valueOf(stringBuilder.charAt(i)));
            numberMix.add(mix);

            BFS(mix, stringBuilder.deleteCharAt(i).toString());
        }
    }
}