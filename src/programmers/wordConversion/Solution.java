package programmers.wordConversion;

import java.util.LinkedList;
import java.util.Queue;

/*
* 각 단어는 알파벳 소문자로만 이루어져 있습니다.
* 각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
* words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
* begin과 target은 같지 않습니다.
* 변환할 수 없는 경우에는 0를 return 합니다.
*/

class Solution {
    public static void main(String[] args) {
        String[] test = new String[] {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution("hit", "cog", test));
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<String> queue =  new LinkedList<>();
        Queue<String[]> wordsQueue =  new LinkedList<String[]>();
        queue.add(begin);
        wordsQueue.add(words);

        while(!queue.isEmpty()) {
            String curWord = queue.remove();
            String[] curWordArr = wordsQueue.remove();

            if(curWord.equals(target)) {
                return words.length - curWordArr.length;
            }

            for(int i = 0; i < curWordArr.length; i++) {
                // 알파벳 하나만 다르면
                if(checkOneDiff(curWord, curWordArr[i])) {
                    String[] tempArr = curWordArr;
                    queue.add(curWordArr[i]);

                    String[] result = new String[curWordArr.length - 1];

                    System.arraycopy(curWordArr, 0, result, 0, i);
                    System.arraycopy(curWordArr, i + 1, result, i, curWordArr.length - i - 1);

                    wordsQueue.add(result);
                }
            }
        }

        return 0;
    }

    public static boolean checkOneDiff(String a, String b) {
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        int diffCnt = 0;

        for(int i = 0; i < arrA.length; i++) {
            diffCnt = arrA[i] != arrB[i] ? diffCnt + 1 : diffCnt;
            if(diffCnt > 1) {
                return false;
            }
        }

        return diffCnt == 1;
    }
}