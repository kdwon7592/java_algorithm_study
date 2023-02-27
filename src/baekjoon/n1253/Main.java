package baekjoon.n1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int answer = 0;

        // 수의 개수
        int n = Integer.parseInt(stringTokenizer.nextToken());

        int[] numArr = new int[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < n; i++){
            numArr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        // 배열 정렬
        Arrays.sort(numArr);

        for (int k = 0; k < n; k++) {
            long find = numArr[k];
            int i = 0;
            int j = n - 1;

            while (i < j) {
                if(numArr[i] + numArr[j] == find) {
                    // 서로 다른 두 수 체크
                    if(i != k && j != k) {
                        answer++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                } else if(numArr[i] + numArr[j] < find) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        System.out.println(answer);
    }
}
