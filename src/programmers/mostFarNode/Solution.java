package programmers.mostFarNode;

import java.util.*;

class Solution {
    public static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) {
        int[][] test = new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(6, test));
    }

    public static int solution(int n, int[][] edge) {
        boolean[] visited = new boolean[n + 1];
        HashMap<Integer, ArrayList<Integer>> list = new HashMap<>();

        // 인접 리스트 생성
        for(int i = 0; i < edge.length; i++) {
            int node1 = edge[i][0];
            int node2 = edge[i][1];

            if(list.get(node1) != null) {
                ArrayList<Integer> temp = list.get(node1);
                temp.add(node2);
                list.put(node1, temp);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(node2);
                list.put(node1, temp);
            }

            if(list.get(node2) != null) {
                ArrayList<Integer> temp = list.get(node2);
                temp.add(node1);
                list.put(node2, temp);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(node1);
                list.put(node2, temp);
            }
        }

        BFS(1, list, visited, 0);
        int max = 0;
        int answer = 0;

        for(int i = 0; i < result.size(); i++) {
            if(max == result.get(i)) {
                answer++;
            } else if (max < result.get(i)) {
                answer = 1;
                max = result.get(i);
            }
        }


        return answer;
    }

    public static void BFS(int currentNode, HashMap<Integer, ArrayList<Integer>> list, boolean[] visited, int distnace) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] {currentNode, distnace});

        while(!queue.isEmpty()) {
            int[] curr = queue.remove();

            if(visited[curr[0]]) {
                continue;
            }

            visited[curr[0]] = true;
            result.add(curr[1]);

            ArrayList<Integer> temp = list.get(curr[0]);
            for(int i = 0; i < temp.size(); i++) {
                if(!visited[temp.get(i)]) {
                    queue.add(new int[]{temp.get(i), curr[1] + 1});
                }
            }
        }
    }
}