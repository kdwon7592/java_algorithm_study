package baekjoon.n1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 데이터의 개수
        int n = Integer.parseInt(st.nextToken());
        int[] nArr = new int[n];

        // 숫자 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(nArr);

        // 찾아야 할 숫자의 개수
        st = new StringTokenizer(br.readLine());
        int findN = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < findN; i++) {
            int find = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = n - 1;
            boolean result = false;

            while (start <= end) {
                int midI = (start + end) / 2;
                int midV = nArr[midI];

                if(midV < find) {
                    start = midI + 1;
                } else if (midV > find) {
                    end = midI - 1;
                } else {
                    result = true;
                    break;
                }
            }

            if(result) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
