package baekjoon.n1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //3 16
    //3 5 7 11 13
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int[] primeNumArr = new int[end + 1];

        for(int i = 2; i <= end; i++) {
            primeNumArr[i] = i;
        }

        for(int i = 2; i <= Math.sqrt(end); i++) {
            if(primeNumArr[i] == 0) {
                continue;
            }
            for(int j = i + i; j <= end; j = j + i) {
                primeNumArr[j] = 0;
            }
        }

        for(int i = start; i <= end; i++) {
            if(primeNumArr[i] != 0) {
                System.out.println(primeNumArr[i]);
            }
        }
    }
}
