# 算法题

## 4. 数字分组求偶数和

### 问题

小M面对一组从 1 到 9 的数字，这些数字被分成多个小组，并从每个小组中选择一个数字组成一个新的数。目标是使得这个新数的各位数字之和为偶数。任务是计算出有多少种不同的分组和选择方法可以达到这一目标。

- `numbers`: 一个由多个整数字符串组成的列表，每个字符串可以视为一个数字组。小M需要从每个数字组中选择一个数字。

例如对于`[123, 456, 789]`，14个符合条件的数为：`147 149 158 167 169 248 257 259 268 347 349 358 367 369`。

------

#### 测试样例

***样例1：***

> 输入：`numbers = [123, 456, 789]`
> 输出：`14`

***样例2：***

> 输入：`numbers = [123456789]`
> 输出：`4`

***样例3：***

> 输入：`numbers = [14329, 7568]`
> 输出：`10`

#### 约束条件

无


### 解答

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
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
```

