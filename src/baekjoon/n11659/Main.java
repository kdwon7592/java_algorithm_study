package baekjoon.n11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        //수의 개수
        int n = Integer.parseInt(stringTokenizer.nextToken());
        //계산 횟수
        int calcN = Integer.parseInt(stringTokenizer.nextToken());

        long[] sumArr = new long[n + 1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 1; i < n + 1; i++) {
            sumArr[i] = sumArr[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int i = 0; i < calcN; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int first = Integer.parseInt(stringTokenizer.nextToken());
            int second = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(sumArr[second]);
            System.out.println(sumArr[first-1]);
            System.out.println(sumArr[second] - sumArr[first-1]);
        }
        bufferedReader.close();
    }
}