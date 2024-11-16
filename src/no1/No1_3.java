package no1;

import java.util.HashMap;
import java.util.Map;

// 哈希表
public class No1_3 {

    public static int solution(int[] cards) {
        Map<Integer, Integer> countMap = new HashMap<>();
        // 统计每个数字的出现次数
        for (int card : cards) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }
        // 找出出现次数为1的数字
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1; // 理论上不会执行到这里，因为题目保证有唯一解
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 2, 2, 3, 3, 4, 5, 5}) == 4);
        System.out.println(solution(new int[]{0, 1, 0, 1, 2}) == 2);
    }

}
