package programmers.moreSpicy;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        final Integer[] pivot = {-1};

        Arrays.stream(arr).boxed().forEach(val -> {
            if(pivot[0] != val) {
                list.add(val);
            }
            pivot[0] = val;
        });

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}