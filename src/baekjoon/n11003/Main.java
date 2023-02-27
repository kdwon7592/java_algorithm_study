package baekjoon.n11003;

import java.io.*;
import java.util.*;

class MyNode {
    Integer index;
    Integer value;
    public MyNode(Integer index, Integer value) {
        this.index = index;
        this.value = value;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int L = Integer.parseInt(stringTokenizer.nextToken());

        ArrayList<Integer> minNumArr = new ArrayList<>();
        Deque<MyNode> deque = new LinkedList<>();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i = 0; i < N; i++) {
            int val = Integer.parseInt(stringTokenizer.nextToken());

            while(!deque.isEmpty() && deque.getLast().value > val) {
                deque.removeLast();
            }

            deque.addLast(new MyNode(i, val));

            if(deque.getFirst().index <= i - L) {
                deque.removeFirst();
            }

            br.write(deque.getFirst().value + " ");
        }

        br.flush();
        br.close();
    }
}
