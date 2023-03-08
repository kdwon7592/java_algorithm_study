package programmers.network;

class Solution {
    public static void main(String[] args) {
        solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
    }

    public static int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;

        for(int i = 0; i < n; i++) {
            if(visited[i] == false) {
                answer++;
                DFS(computers, visited, i);
            }
        }

        return answer;
    }

    public static void DFS(int[][] computers, boolean[] visited, int line) {
        visited[line] = true;

        for(int i = 0; i < computers.length; i++) {
            // 현재 라인에서 자신이 아니고 다른 컴퓨터와 연결이 되어있고 방문하지 않았다면
            if(computers[line][i] == 1 && !visited[i]) {
                visited[i] = true;
                DFS(computers, visited, i);
            }
        }
    }
}