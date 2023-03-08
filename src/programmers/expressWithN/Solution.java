package programmers.expressWithN;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        System.out.println(solution(8, 5800));
    }

    public static int solution(int N, int number) {
        HashMap<Integer, ArrayList<Integer>> allExpression = new HashMap<>();

        // 한번만 써서 만들 수 있는 숫자 초기화
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(N);
        allExpression.put(1, arrayList);

        for(int i = 2; i <= 8; i++) {
            ArrayList<Integer> newList = new ArrayList<>();
            for(int k = 1; k <= i / 2; k ++) {
                ArrayList<Integer> tempList1 = allExpression.get(i - k);
                ArrayList<Integer> tempList2 = allExpression.get(k);

                for(int t1 = 0; t1 < tempList1.size(); t1++) {
                    for(int t2 = 0; t2 < tempList2.size(); t2++) {

                        int temp1 = tempList1.get(t1);
                        int temp2 = tempList2.get(t2);
                        // 더하기
                        newList.add(temp1 + temp2);
                        // 빼기
                        newList.add(temp1 - temp2);
                        // 빼기
                        newList.add(temp2 - temp1);
                        // 곱하기
                        newList.add(temp1 * temp2);
                        // 나누기
                        if(temp2 != 0) {
                            newList.add(temp1 / temp2);
                        }
                        // 나누기
                        if(temp1 != 0) {
                            newList.add(temp2 / temp1);
                        }
                        // 스트링더하기
                        newList.add(Integer.valueOf(String.valueOf(temp1) + String.valueOf(N)));
                    }
                }

            }

            allExpression.put(i, newList);
        }

        for(int i = 1; i <= 8; i++) {
            ArrayList<Integer> tempList = allExpression.get(i);
            for(int j = 0; j < tempList.size(); j++) {
                if(number == tempList.get(j)) {
                    return i;
                }
            }
        }

        return -1;
    }
}