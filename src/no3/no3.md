# 算法题

## 3. 数字字符串格式化

### 问题

小M在工作时遇到了一个问题，他需要将用户输入的不带千分位逗号的数字字符串转换为带千分位逗号的格式，
并且保留小数部分。小M还发现，有时候输入的数字字符串前面会有无用的 0，这些也需要精简掉。
请你帮助小M编写程序，完成这个任务。

------

#### 测试样例

样例1：

输入：s = "1294512.12412"
输出：'1,294,512.12412'

样例2：

输入：s = "0000123456789.99"
输出：'123,456,789.99'

样例3：

输入：s = "987654321"
输出：'987,654,321'


#### 约束条件

### 解答

```java
public class Main {
    public static String solution(String s) {
        String strhou = "";
        String strqian = "";
        // 分割字符串
        if (s.indexOf(".") != -1) {
            // 小数点后的部分
            strhou = s.split("\\.")[1];
            // 小数点前的部分
            strqian = s.split("\\.")[0];
        } else {
            strqian = s;
        }

        // 对开头为0的处理
        String str = "";
        boolean count = true;
        for (int i = 0; i < strqian.length(); i++) {
            if (count) {
                if (strqian.charAt(i) == '0') {
                    continue;
                } else {
                    count = false;
                }
            }
            str += strqian.charAt(i);
        }

        // 对str添加","符号
        int count1 = 0;
        String str1 = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            str1 = str.charAt(i) + str1;
            count1++;
            if (i==0){
                break;
            }
            if (count1 == 3) {
                str1 = "," + str1;
                count1 = 0;
            }
        }
        if(strhou.length()>0){
            return str1+"."+strhou;
        }
        return str1;
    }

    public static void main(String[] args) {
        System.out.println(solution("1294512.12412").equals("1,294,512.12412"));
        System.out.println(solution("0000123456789.99").equals("123,456,789.99"));
        System.out.println(solution("987654321").equals("987,654,321"));
    }
}
```

