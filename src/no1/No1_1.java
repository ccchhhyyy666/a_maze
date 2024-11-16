package no1;

public class No1_1 {
    public static int solution(int[] cards) {
        int num = 0;
        int tesu = 0;
        for (int i : cards) {
            tesu = i;
            for (int j : cards) { // 导致时间复杂度增加
                if (i == j) {
                    num += 1;
                }
            }
            if (num != 2) {
                break;
            }
            num = 0;
        }
        return tesu;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 2, 2, 3, 3, 4, 5, 5}) == 4);
        System.out.println(solution(new int[]{0, 1, 0, 1, 2}) == 2);
    }
}
