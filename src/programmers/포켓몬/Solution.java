package programmers.포켓몬;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        Integer[] newNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        int N = newNums.length;
        Set<Integer> set = new HashSet<>(Arrays.asList(newNums));

        if(set.size() < (N / 2)) {
            return set.size();
        } else {
            return N / 2;
        }
    }
}