package baekjoon.n11720;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String sNum = scanner.next();
        char[] cNum = sNum.toCharArray();

        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += cNum[i] - '0';
        }
        System.out.println(sum);
    }
}