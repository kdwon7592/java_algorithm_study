package baekjoon.n11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] nodes;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        // 노드 개수
        int n = Integer.parseInt(stringTokenizer.nextToken());
        // 에지 개수
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int count = 0;

        nodes = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(visited, false);
        for (int i = 1; i < n + 1; i++) { // 인접 리스트 초기화하기
            nodes[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int node1 = Integer.parseInt(stringTokenizer.nextToken());
            int node2 = Integer.parseInt(stringTokenizer.nextToken());

            nodes[node1].add(node2); // 1 - 2
            nodes[node2].add(node1); // 2 - 1 , 5
        }

        for(int i = 1; i < n + 1; i++) {
            if(!visited[i]) {
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    static void DFS(int v) {
        if(visited[v]) {
            return;
        }
        visited[v] = true;
        //2 - 1, 5, 4, 3
        for(int i : nodes[v]) {
            if(visited[i] == false) {
                DFS(i);
            }
        }

    }
}
