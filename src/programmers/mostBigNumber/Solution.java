package programmers.mostBigNumber;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

//[6, 10, 2]	"6210"
//[3, 30, 34, 5, 9]	"9534330"
// 1번 앞자리가 큰 순으로 정렬
// 2번 2번째자리가 큰순으로 정렬
// ....
// 한자리수부터 연결

class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 00, 9, 00, 0 , 0}));
    }
    public static String solution(int[] numbers) {
        //int 배열을 String으로
        String[] strNumbers = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }}
        );
        String answer = Arrays.stream(strNumbers).reduce((x, y) -> x + y).get();
        return answer.startsWith("0") ? "0" : answer ;
    }
}