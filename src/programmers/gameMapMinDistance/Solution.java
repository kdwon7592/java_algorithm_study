package programmers.gameMapMinDistance;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        int[][] test = new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
//        int[][] test = new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
//        int[][] test = new int[][] {{1,0,0,0,0,0},{1,0,0,0,0,0},{1,0,0,0,0,0},{1,0,0,0,0,0},{1,0,0,0,0,0}};
        System.out.println(solution(test));
    }

    public static int solution(int[][] maps) {
        if(maps[0][0] == 0) {
            return -1;
        }
        // maps = n * m;
        int n = maps.length;
        int m = maps[0].length;
        int[][] minDistance = new int[n][m];
        for (int[] i : minDistance) Arrays.fill(i, -1);

//        dfs(maps, minDistance, 0 ,0, 1);
        bfs(maps, minDistance, n ,m, 1);

        return minDistance[n-1][m-1];
    }

    public static void dfs(int[][] maps, int[][] minDistance, int n, int m, int distance) {
        if(maps[n][m] == 0 || minDistance[n][m] != -1) {
            return;
        }

        minDistance[n][m] = distance;

        // 오른쪽 이동
        if(m < maps[0].length - 1) {
            dfs(maps, minDistance, n, m + 1, distance + 1);
        }
        // 아래쪽 이동
        if(n < maps.length - 1) {
            dfs(maps, minDistance, n + 1, m, distance + 1);
        }
        // 왼쪽 이동
        if(m > 0) {
            dfs(maps, minDistance, n , m - 1, distance + 1);
        }
        // 위쪽 이동
        if(n > 0) {
            dfs(maps, minDistance, n - 1 , m, distance + 1);
        }
    }

    public static void bfs(int[][] maps, int[][] minDistance, int n, int m, int distance) {
        Queue<int[]> queue = new LinkedList<int[]>();
        int[] dy = {0,0,1,-1};
        int[] dx = {1,-1,0,0};

        queue.add(new int[] {0 , 0});
        minDistance[0][0] = distance;

        while(!queue.isEmpty()) {
            int[] now_Node = queue.remove();

            int y = now_Node[0];
            int x = now_Node[1];

            for(int i = 0 ; i < 4; i++) {
                int qy = y + dy[i];
                int qx = x + dx[i];

                if(qx >= m || qy >= n || qx < 0 || qy < 0) {
                    continue;
                }

                if(maps[qy][qx] == 0 || minDistance[qy][qx] != -1) {
                    continue;
                }

                queue.add(new int[] {qy, qx});
                minDistance[qy][qx] = minDistance[y][x] + 1;
            }
        }
    }
}