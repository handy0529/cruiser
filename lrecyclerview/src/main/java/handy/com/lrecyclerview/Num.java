package com.handy.cruiser.utils;

/**
 * Created by handy on 16/10/23.
 */

public class Num {

        private static final char[] data = new char[]{'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'};
        private static final char[] units = new char[]{'元','拾','佰','仟','万','拾','佰','仟','亿'};

    /*去零的代码
    return sb.reverse().toString().replaceAll("零[拾佰仟]","零").replaceAll("零+万","万").replaceAll("零+元","元").replaceAll("零+","零");*/
    /*去零倒序
    return sb.reverse().toString().replaceAll("零[拾佰仟]","零").replaceAll("零+万","万").replaceAll("零+元","元").replaceAll("零+","零");*/

        public static void main(String[] args) {
            System.out.println(convert(230009));
            System.out.println(convert(220030009));
            System.out.println(convert(111230009));
            System.out.println(convert(555523000));
        }

        private static String convert(int money) {
            StringBuffer sbf = new StringBuffer();
            int unit = 0;
            while(money!=0)
            {
                sbf.insert(0,units[unit++]);
                int number = money%10;
                sbf.insert(0, data[number]);
                money /= 10;
            }
            return sbf.toString().replaceAll("零[拾佰仟]","零").replaceAll("零+万","万").replaceAll("零+元","元").replaceAll("零+","零");
        }

}
