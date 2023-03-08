package baekjoon.n1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] nodes;
    static boolean DFSVisited[];
    static boolean BFSVisited[];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        // 노드 개수
        int n = Integer.parseInt(stringTokenizer.nextToken());
        // 에지 개수
        int m = Integer.parseInt(stringTokenizer.nextToken());
        // 시작 노드
        int v = Integer.parseInt(stringTokenizer.nextToken());

        nodes = new ArrayList[n + 1];
        DFSVisited = new boolean[n + 1];
        BFSVisited = new boolean[n + 1];
        Arrays.fill(DFSVisited, false);
        Arrays.fill(BFSVisited, false);

        for (int i = 1; i < n + 1; i++) { // 인접 리스트 초기화하기
            nodes[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int node1 = Integer.parseInt(stringTokenizer.nextToken());
            int node2 = Integer.parseInt(stringTokenizer.nextToken());

            nodes[node1].add(node2); // 1 - 2
            nodes[node2].add(node1); // 2 - 1 , 5

            Collections.sort(nodes[node1]);
            Collections.sort(nodes[node2]);
        }

        DFS(v);
        System.out.println();

        BFS(v);
    }

    static void DFS(int v) {
        if(DFSVisited[v]) {
            return;
        }
        DFSVisited[v] = true;
        System.out.print(v + " ");
        //2 - 1, 5, 4, 3
        for(int i : nodes[v]) {
            if(!DFSVisited[i])  {
                DFS(i);
            }
        }
    }

    static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(v);
        BFSVisited[v] = true;

        while(!queue.isEmpty()) {
            int now_Node = queue.poll();
            System.out.print(now_Node + " ");
            for(int i : nodes[now_Node]) {
                if(!BFSVisited[i]) {
                    BFSVisited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
