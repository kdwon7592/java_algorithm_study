package programmers.numberOfK;

import java.util.ArrayList;
import java.util.Arrays;

//[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]

class Solution {
    public static void main(String[] args) {
        solution(null, null);
    }
    public static int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < commands.length; i++) {
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            arrayList.add(temp[commands[i][2]-1]);
        }

        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }
}