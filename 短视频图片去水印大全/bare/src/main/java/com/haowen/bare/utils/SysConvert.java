package com.haowen.bare.utils;

public class SysConvert {

    //声明当前对象
    private static SysConvert instance = new SysConvert();
    //可用计数字符
    private static String unit = "0123456789abcdefghijklmnopqrstuvwxyz";
    //输入数字
    private String number;
    //输入进制
    private int sysIn;
    //输出进制
    private int sysOut;
    //输入实际值
    private double actualValue;
    //小数计算精度
    private int precision;
    //用于存放结果
    private StringBuilder result = new StringBuilder();

    private SysConvert() {
    }

    public static SysConvert getInstance() {
        return instance;
    }

    /**
     * 获取当前位所代表的值
     *
     * @param sys   进制数
     * @param index 距离小数点的距离
     * @param var   当前位表示字符
     * @return 当前位所代表的值
     */
    private static double changeNI(int sys, int index, char var) {
        return unit.indexOf(var) * Math.pow(sys, index);
    }

    /**
     * 将值转化为对应进制表示字符
     *
     * @param sys 进制数
     * @param var 值
     * @return 对应进制表示字符
     */
    private static char changeIN(int sys, int var) {
        return unit.charAt(var);
    }

    /**
     * 计算实际值
     */
    private void calculateActualValue() {
        //检查小数点
        int pointIndex = number.indexOf('.');

        //计算整数部分
        if (pointIndex < 0) {//如果没有小数部分
            for (int i = 0; i < number.length(); i++) {
                actualValue += (long) changeNI(sysIn, i, number.charAt(number.length() - i - 1));
            }
        } else {//有则
            for (int i = 0; i < pointIndex; i++) {
                actualValue += (long) changeNI(sysIn, i, number.charAt(pointIndex - i - 1));
            }
        }

        if (!(pointIndex < 0)) {//如果有小数部分
            //计算小数部分
            for (int i = pointIndex + 1; i < number.length(); i++) {
                actualValue += changeNI(sysIn, pointIndex - i, number.charAt(i));
            }
        }
    }

    /**
     * 转换为指定进制
     */
    private void Convert() {
        //分离整数和小数
        long integerPart = (long) actualValue;
        double decimalsPart = actualValue - integerPart;

        //建立字符串以用于保存结果
        while (integerPart >= sysOut) { //反复除进制,取余数
            result.insert(0, changeIN(sysOut, (int) (integerPart % sysOut))); //追加结果
            integerPart = integerPart / sysOut;//商
        }
        if (integerPart != 0) { //如果最后未被除尽
            result.insert(0, changeIN(sysOut, (int) integerPart)); //追加结果
        }

        if (decimalsPart > 0) { //如果有小数部分
            //添加小数点
            result.append(".");
            for (int t = 0; t < precision; t++) {
                decimalsPart = decimalsPart * sysOut;
                result.append(changeIN(sysOut, (int) decimalsPart));
                decimalsPart = decimalsPart - (int) decimalsPart;
            }
        }
    }

    /**
     * 进制转换
     *
     * @param sysIn     输入进制(Input base)
     * @param sysOut    输出进制(Output base)
     * @param number    输入数字(Input number)
     * @param precision 输出精度(非小数此参数无效)(Output precision (non-decimal this parameter is not valid))
     * @return 输出转换结果
     */
    public String Convert(int sysIn, int sysOut, String number, int precision) {
        this.sysIn = sysIn;
        this.sysOut = sysOut;
        this.number = number;
        this.precision = precision;
        actualValue = 0;
        result.delete(0, result.length());
        calculateActualValue();
        Convert();
        return result.toString();
    }
}
