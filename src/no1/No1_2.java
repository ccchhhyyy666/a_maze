package no1;

// 异或运算——最优解
public class No1_2 {
    public static int solution(int[] cards) {
        int tesu = 0;
        for (int i : cards) {
            tesu ^= i;
        }
        return tesu;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 2, 2, 3, 3, 4, 5, 5}) == 4);
        System.out.println(solution(new int[]{0, 1, 0, 1, 2}) == 2);
    }

}
