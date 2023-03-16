package programmers.printer;

//      제한사항
//        현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
//        인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
//        location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.
//
//      입출력 예
//        [2, 1, 3, 2]	2	1
//        [1, 1, 9, 1, 1, 1]	0	5

import java.util.*;
import java.util.stream.Collectors;

class TempMap {
    private int key;
    private int value;

    public TempMap(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}

class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 1, 9, 1, 1, 1}, 0));
    }
    static int solution(int[] priorities, int location) {
        Queue<TempMap> queue = new LinkedList<>();

        for(int i = 0 ; i < priorities.length; i++) {
            TempMap tempMap = new TempMap(i, priorities[i]);
            queue.add(tempMap);
        }

        int printCnt = 0;

        while(!queue.isEmpty()) {
            int qSize = queue.size();
            TempMap tempMap = queue.remove();

            TempMap[] obj = queue.stream().collect(Collectors.toList()).toArray(new TempMap[queue.size()]);

            for(TempMap temp : obj) {
                if(tempMap.getValue() < temp.getValue()) {
                    queue.add(tempMap);
                    break;
                }
            }

            if(qSize != queue.size()) {
                if(tempMap.getKey() == location) {
                    return printCnt + 1;
                }

                printCnt++;
            }
        }

        return printCnt;
    }
}