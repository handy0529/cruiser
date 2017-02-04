package com.handy.cruiser.utils;


/**
 * Created by handy on 16/10/23.
 */

public class Num3Rmb
{
    private String[] hanArr = {"零" , "壹" , "贰" , "叁" , "肆" ,
            "伍" , "陆" , "柒" , "捌" , "玖"};
    private String[] unitArr = {"分","角","元","拾","佰","仟","万","拾","佰","仟","亿","拾","佰","仟"};

    /**
     * 把一个浮点数分解成整数部分和小数部分字符串
     * @param num 需要被分解的浮点数
     * @return 分解出来的整数部分和小数部分。第一个数组元素是整数部分，第二个数组元素是小数部分。
     */
    private Long[] divide(double num)
    {
        //将一个浮点数强制类型转换为long，即得到它的整数部分
        long zheng =  (long)num;

        //浮点数减去整数部分，得到小数部分，小数部分乘以100后再取整得到2位小数
        long xiao = (long)Math.round((num - zheng) * 100);

        return new Long[]{zheng,xiao};
    }

    /**
     * 把数字字符串变成汉字字符串
     * @param numStr 需要被转换的数字字符串
     * @return数字字符串被转换成的汉字字符串。
     */
    private String toHanStr(String numStr)
    {
        String.valueOf(numStr);
        System.out.println(numStr);
        String result = "";
        int numLen = numStr.length();
        int  index;
        System.out.println(numLen);
        //依次遍历数字字符串的每一位数字
        for (int i = 0 ; i < numLen ; i++ )
        {
            //把char型数字转换成的int型数字，因为它们的ASCII码值恰好相差48
            //因此把char型数字减去48得到int型数字，例如'4'被转换成4。
            int num = numStr.charAt(i) - 48;
            System.out.println(num);
            //如果不是最后一位数字，而且数字不是零，则需要添加单位（千、百、十）
            if (i >= (numLen - unitArr.length)) {//如果不是大于最大的单位，就需要加上单位
                         /*计算出使用哪位文字计算单位.unitArr.Length为已给的文字单位长度,
                        *index计算出要使用的文字单位
                        */
                index = unitArr.length - 1 - (i - (numLen - unitArr.length));
                result += hanArr[num] + unitArr[index];
            }
            else {
                result += hanArr[num];
            }
        }
        return result;
    }

    public static void main(String[] args) //主函数
    {        Num3Rmb nr = new Num3Rmb();
        //测试把一个浮点数分解成整数部分和小数部分
        Long[] b=nr.divide(299936711125.1);
        System.out.println(b[0]);
        Long money = b[0] * 100 + b[1];


        //测试把一个数字字符串变成汉字字符串

        System.out.println(nr.toHanStr(money.toString()));
    }
}