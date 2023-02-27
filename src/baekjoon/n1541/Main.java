package baekjoon.n1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //55-50+40
    //10+20+30+40
    //00009-00009
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] inputArr = input.split("-");
        int[] processDataArr = new int[inputArr.length];

        for(int i = 0; i < inputArr.length; i++) {
            String[] temp = inputArr[i].split("\\+");
            int tempSum = 0;
            for(int j = 0; j < temp.length; j++) {
                tempSum += Integer.parseInt(temp[j]);
            }
            processDataArr[i] = tempSum;
        }

        int result = processDataArr[0];

        for(int i = 1; i < processDataArr.length; i++) {
            result -= processDataArr[i];
        }

        System.out.println(result);
    }
}
