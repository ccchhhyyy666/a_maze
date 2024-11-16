package no4;

import java.util.ArrayList;
import java.util.List;

public class No4_1 {
    public static int solution(int[] numbers) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int a : numbers) {
            List<Integer> list = new ArrayList<Integer>();
            for (;;) {
                if (a < 10) {
                    list.add(a);
                    break;
                }
                list.add(a % 10);
                a /= 10;
            }
            lists.add(list);
        }
        return countnum(lists, 0, 0);
    }

    public static int countnum(List<List<Integer>> a, int index, int num) {
        if (index == a.size()) {
            return num % 2 == 0 ? 1 : 0;
        }
        int count = 0;
        for (int i : a.get(index)) {
            count += countnum(a, index + 1, i + num);
        }
        return count;
    }

    public static void main(String[] args) {
        // You can add more test cases here
        System.out.println(solution(new int[] { 123, 456, 789 }) == 14);
        System.out.println(solution(new int[] { 123456789 }) == 4);
        System.out.println(solution(new int[] { 14329, 7568 }) == 10);
    }
}