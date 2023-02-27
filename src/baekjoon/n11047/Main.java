package baekjoon.n11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

//            10 4790
//            1
//            5
//            10
//            50
//            100
//            500
//            1000
//            5000
//            10000
//            50000
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 동전 갯수
        int n = Integer.parseInt(st.nextToken());
        int[] nArr = new int[n];

        // 금액
        int money = Integer.parseInt(st.nextToken());

        // 숫자 입력
        for(int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(br.readLine());
        }
        int k = 0;

        for(int i = n-1 ; i >= 0; i--) {
            while(nArr[i] <= money) {
                System.out.println(money);
                money = money - nArr[i];
                k++;
            }
        }

        System.out.println(k);
    }
}
