package programmers.phoneBook;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
* phone_book의 길이는 1 이상 1,000,000 이하입니다.
* 각 전화번호의 길이는 1 이상 20 이하입니다.
* 같은 전화번호가 중복해서 들어있지 않습니다.
*/

class Solution {
    public static void main(String[] args) {
        String[] test = new String[] {"000", "0010", "12","134","1355","567","88", "234" , "278", "2796" , "333", "32334"};
        System.out.println(solution(test));
    }

    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length - 1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}