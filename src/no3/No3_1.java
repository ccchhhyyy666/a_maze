package no3;

public class No3_1 {
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
            if (i == 0) {
                break;
            }
            if (count1 == 3) {
                str1 = "," + str1;
                count1 = 0;
            }
        }
        if (strhou.length() > 0) {
            return str1 + "." + strhou;
        }
        return str1;
    }

    public static void main(String[] args) {
        System.out.println(solution("1294512.12412").equals("1,294,512.12412"));
        System.out.println(solution("0000123456789.99").equals("123,456,789.99"));
        System.out.println(solution("987654321").equals("987,654,321"));
    }

}
