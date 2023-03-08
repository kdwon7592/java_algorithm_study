package programmers.integerTriangle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        solution(new int[][] {{7}, {3,8},  {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
    }

    public static int solution(int[][] triangle) {
        int[][] maxVal = new int[triangle.length][];
        maxVal[0] = new int[1];
        maxVal[0][0] = triangle[0][0];

        for(int i = 1; i < triangle.length; i++) {
            maxVal[i] = new int[triangle[i].length];
            for(int j = 0; j < triangle[i].length; j++) {
                if(j == 0) { // 첫번째 노드
                    maxVal[i][j] = triangle[i][j] + maxVal[i-1][j];
                } else if (j == triangle[i].length - 1) { // 마지막 노드
                    maxVal[i][j] = triangle[i][j] + maxVal[i-1][j-1];
                } else {
                    maxVal[i][j] = Math.max((triangle[i][j] + maxVal[i-1][j]), (triangle[i][j] + maxVal[i-1][j-1]));
                }
            }
        }
        int[] resultArr = maxVal[triangle.length-1];
        int result = 0;
        for(int i = 0; i < resultArr.length; i++) {
            result = Math.max(result,resultArr[i]);
        }

        return result;
    }
}