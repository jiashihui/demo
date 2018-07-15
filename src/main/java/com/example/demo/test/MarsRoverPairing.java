package com.example.demo.test;

import java.util.Scanner;
import java.util.regex.Pattern;


/**
 * Test Input:
 * 5 5
 * 1 2 N
 * LMLMLMLMM
 * 3 3 E
 * MMRMMRMRRM
 * Expected Output:
 * 1 3 N
 * 5 1 E
 */
public class MarsRoverPairing {

    private static int x_range;
    private static int y_range;
    private static int x;
    private static int y;
    private static char p;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = 1;
        String result = "";

        // 打印输入说明
        getInstruction();

        do {
            String readLine = scan.nextLine();

            switch (count) {
                case 1:
                    initCoordinate(readLine);
                    System.out.println("调用方法1后输出数据:" + result);
                    break;
                case 2:
                    result = readLine;
                    initPosition(readLine);
                    System.out.println("调用方法2后输出数据:" + result);
                    break;
                case 3:
                    result = getChangePosition(readLine);
                    System.out.println("调用方法3后输出数据:" + result);
                    break;
                default:
                    System.out.println("结束输入后输出最终结果:" + result);
            }
            // 不输入，按下回车键，结束程序
            if (readLine.equals("")) {
                break;
            }
            // 输入正确次数计数
            count++;
        } while (true);
    }

    /**
     * 初始化坐标范围
     * @param readLine
     */
    private static void initCoordinate(String readLine) {
        String[] strs = readLine.split(" ");
        // 判断是否输入两位
        if (strs.length != 2) {
            throw new MyException(MessageCode.CAPACITY_EXCEPTION,MessageCode.CAPACITY_EXCEPTION_MSG, "2");
        }

        // 判断是否是数字
        Pattern pattern = Pattern.compile("[0-9]");
        if( !(pattern.matcher(strs[0])).matches() || !(pattern.matcher(strs[1])).matches()){
            throw new MyException(MessageCode.RANGE_INPUT_EXCEPTION,MessageCode.RANGE_INPUT_EXCEPTION_MSG);
        }

        x_range = Integer.parseInt(strs[0]);
        y_range = Integer.parseInt(strs[1]);
    }

    /**
     * 位置初始化
     * @param readLine
     */
    private static void initPosition(String readLine) {
        String[] strs = readLine.split(" ");

        // 判断是否输入三位
        if (strs.length != 3) {
            throw new MyException(MessageCode.CAPACITY_EXCEPTION,MessageCode.CAPACITY_EXCEPTION_MSG, "3");
        }

        // 判断是否是数字
        Pattern pattern = Pattern.compile("[0-9]");
        if( !(pattern.matcher(strs[0])).matches() || !(pattern.matcher(strs[1])).matches()){
            throw new MyException(MessageCode.POSITION_INPUT_EXCEPTION,MessageCode.POSITION_INPUT_EXCEPTION_MSG);
        }

        // 判断是否是方向字符
        if(!Constant.directions.contains(strs[2])){
            throw new MyException(MessageCode.POSITION_INPUT_EXCEPTION,MessageCode.POSITION_INPUT_EXCEPTION_MSG);
        }

        x = Integer.parseInt(strs[0]);
        y = Integer.parseInt(strs[1]);
        p = (strs[2].toCharArray())[0];
    }

    /**
     * 执行移动后的位置
     * @param readLine
     * @return
     * @throws Exception
     */
    private static String getChangePosition(String readLine) {
        char[] chars = readLine.toCharArray();
        for (char ch : chars) {
            switch (ch) {
                case 'M':
                    move();
                    break;
                case 'L':
                    turnL();
                    break;
                case 'R':
                    turnR();
                    break;
                default:
                    throw new MyException(MessageCode.MOVE_INPUT_EXCEPTION,MessageCode.MOVE_INPUT_EXCEPTION_MSG);
            }
        }
        return x + " " + y + " " + p;
    }

    /**
     * 执行移动
     * @throws Exception
     */
    private static void move() {
        switch (p) {
            case 'E':
                x = x + 1;
                if(x > x_range){
                    throw new MyException(MessageCode.OUT_X_EXCEPTION,MessageCode.OUT_X_EXCEPTION_MSG,"X");
                }
                break;
            case 'S':
                y = y - 1;
                if(y < 0){
                    throw new MyException(MessageCode.OUT_X_EXCEPTION,MessageCode.OUT_X_EXCEPTION_MSG,"Y");
                }
                break;
            case 'W':
                x = x - 1;
                if(x < 0){
                    throw new MyException(MessageCode.OUT_X_EXCEPTION,MessageCode.OUT_X_EXCEPTION_MSG,"X");
                }
                break;
            case 'N':
                y = y + 1;
                if(y > y_range){
                    throw new MyException(MessageCode.OUT_X_EXCEPTION,MessageCode.OUT_X_EXCEPTION_MSG,"Y");
                }
                break;
            default:
        }
    }

    /**
     * 执行向左转动
     * @throws Exception
     */
    private static void turnL() {
        switch (p) {
            case 'E':
                p = 'N';
                break;
            case 'S':
                p = 'E';
                break;
            case 'W':
                p = 'S';
                break;
            case 'N':
                p = 'W';
                break;
            default:
        }

    }

    /**
     * 执行向右转动
     * @throws Exception
     */
    private static void turnR() {
        switch (p) {
            case 'E':
                p = 'S';
                break;
            case 'S':
                p = 'W';
                break;
            case 'W':
                p = 'N';
                break;
            case 'N':
                p = 'E';
                break;
            default:
        }

    }

    /**
     * 输入说明
     */
    private static void getInstruction() {
        System.out.println("第一行输入坐标范围，格式为【n n】，n为正整数，中间为空格；");
        System.out.println("第二行输入初始位置，格式为【n n d】，n为0-9的数字，d为字母E、W、S、N其中之一，代表方向；");
        System.out.println("第三行输入移动参数，格式为只包含L、R、M的字符串；");
        System.out.println("每行输入结束后请按回车键执行；");
        System.out.println("不输入任何参数情况，按动回车键，则表示退出执行。");
    }

}

/**
 * 自定义异常
 */
class MyException extends RuntimeException {
    /**
     * 错误编码
     */
    private String errorCode;


    /**
     * 构造一个基本异常.
     *
     * @param message 信息描述
     */
    public MyException(String message) {
        super(message);
    }

    /**
     * 构造一个基本异常.
     *
     * @param errorCode 错误编码
     * @param message   信息描述
     * @param num 输入有效位数
     */
    public MyException(String errorCode, String message, String num) {
        super(message.replace("{}", num));
        this.setErrorCode(errorCode);
    }

    /**
     * 构造一个基本异常.
     *
     * @param errorCode 错误编码
     * @param message   信息描述
     */
    public MyException(String errorCode, String message) {
        super(message);
        this.setErrorCode(errorCode);
    }

    /**
     * 构造一个基本异常.
     *
     * @param errorCode 错误编码
     * @param message   信息描述
     */
    public MyException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.setErrorCode(errorCode);
    }

    /**
     * 构造一个基本异常.
     *
     * @param message 信息描述
     * @param cause   根异常类（可以存入任何异常）
     */
    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}

/**
 * 自定义异常信息
 */
interface MessageCode {
    // 坐标范围异常
    String RANGE_INPUT_EXCEPTION = "-100";
    String RANGE_INPUT_EXCEPTION_MSG = "输入参数异常，请确认输入参数格式，如：5 5 。";

    // 位数不正确
    String CAPACITY_EXCEPTION = "-1000";
    String CAPACITY_EXCEPTION_MSG = "输入参数位数异常，请输入{}位参数，中间以空格隔开。";

    // 输入初始位置参数异常
    String POSITION_INPUT_EXCEPTION = "-200";
    String POSITION_INPUT_EXCEPTION_MSG = "输入参数异常，请确认输入参数格式，如：1 2 N 。";

    // 输入移动转动参数异常
    String MOVE_INPUT_EXCEPTION = "-300";
    String MOVE_INPUT_EXCEPTION_MSG = "输入参数异常，请确认输入参数格式，该输入只能是大写字母L、R、M，如： LRM 。";

    // 输入移动参数超出范围异常
    String OUT_X_EXCEPTION = "-400";
    String OUT_X_EXCEPTION_MSG = "{}轴的移动超出范围。";

}

/**
 * 自定义常量
 */
interface Constant {
    // 包含所有方向字符的字符串
    String directions = "EWSN";
    // 包含所有移动字符的字符串
    String moves = "LRM";
}
