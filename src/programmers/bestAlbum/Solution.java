package programmers.bestAlbum;

import java.util.*;

// genres	plays	return
//["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]

// 1. 장르별로 plays 합산 배열
// classic - 500, 0
// classic -

class Solution {
    public static void main(String[] args) {
        String[] genres = new String[] {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[] {500, 600, 150, 800, 2500};

        solution(genres, plays);
    }

    public static int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, HashMap<Integer, Integer>> topTwoIndex = new HashMap<>();
        HashMap<String, Integer> popularGenre = new HashMap<>();

        // play가 많이 된 장르 계산
        for(int i = 0; i < genres.length; i++) {
            // 장르가 이미 있으면 플레이수 합산
            if(popularGenre.get(genres[i]) != null) {
                popularGenre.put(genres[i], popularGenre.get(genres[i]) + plays[i]);
            } else {
                popularGenre.put(genres[i], plays[i]);
            }

            if(topTwoIndex.get(genres[i]) != null) {
                if(topTwoIndex.get(genres[i]).size() < 2) {
                    topTwoIndex.get(genres[i]).put(i, plays[i]);
                } else {
                    List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(topTwoIndex.get(genres[i]).entrySet());
                    entryList.sort(Map.Entry.comparingByValue());

                    for(Map.Entry<Integer, Integer> entry : entryList){
                        if(plays[i] > entry.getValue()) {
                            topTwoIndex.get(genres[i]).put(i, plays[i]);
                            topTwoIndex.get(genres[i]).remove(entry.getKey());
                            break;
                        }
                    }
                }
            } else {
                HashMap<Integer, Integer> tempMap = new HashMap<>();
                tempMap.put(i, plays[i]);
                topTwoIndex.put(genres[i], tempMap);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(popularGenre.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // 내림차순 정렬
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for(Map.Entry<String, Integer> entry : entryList){
            topTwoIndex.get(entry.getKey()).entrySet().stream().sorted((o1, o2) -> {return o2.getValue().compareTo(o1.getValue());}).forEach((map) -> {
                answer.add(map.getKey());
            });
        }


        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}