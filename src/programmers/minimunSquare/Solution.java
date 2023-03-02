package programmers.minimunSquare;

class Solution {
    public int solution(int[][] sizes) {
        int[] bigLens = new int[sizes.length];
        int[] smallLens = new int[sizes.length];

        int maxBig = 0;
        int maxSmall = 0;

        for(int i = 0; i < sizes.length; i++) {
            if(sizes[i][0] > sizes[i][1]) {
                bigLens[i] = sizes[i][0];
                smallLens[i] = sizes[i][1];
            } else {
                bigLens[i] = sizes[i][1];
                smallLens[i] = sizes[i][0];
            }

            maxBig = maxBig < bigLens[i] ? bigLens[i] : maxBig;
            maxSmall = maxSmall < smallLens[i] ? smallLens[i] : maxSmall;
        }

        return maxBig * maxSmall;
    }
}