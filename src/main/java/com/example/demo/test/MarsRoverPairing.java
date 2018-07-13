package com.example.demo.test;

import java.util.Scanner;


/**
 * Test Input:
 5 5
 1 2 N
 LMLMLMLMM
 3 3 E
 MMRMMRMRRM
 Expected Output:
 1 3 N
 5 1 E
 */
public class MarsRoverPairing {

    private static int x_range;
    private static int y_range;
    private static int x;
    private static int y;
    private static String p;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = 0;
        String result = "";
        do {
            String readLine = scan.nextLine();

            switch (count) {
                case 1 :
                    initCoordinate(readLine);
                    System.out.println("调用方法1:" + result);
                case 2 :
                    result = readLine;
                    initPosition(readLine);
                    System.out.println("调用方法2:" + result);
                case 3 :
                    try {
                        result = getChangePosition(readLine);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("调用方法3:" + result);
                default:
                    System.out.println("输出结果");
            }

            if (readLine.equals("")) {
                break;
            }
            System.out.println("输入数据："+readLine);
            count++;
        } while (true);
    }

    private static void initCoordinate (String readLine) {
        String[] strs = readLine.split(" ");
        x_range = Integer.parseInt(strs[0]);
        y_range = Integer.parseInt(strs[1]);
    }

    private static void initPosition (String readLine) {
        String[] strs = readLine.split(" ");
        x = Integer.parseInt(strs[0]);
        y = Integer.parseInt(strs[1]);
        p = strs[2];

    }

    private static String getChangePosition (String readLine) throws Exception {
        char[] chars = readLine.toCharArray();
        for (char ch : chars) {
            switch (ch) {
                case 'M' :
                    move();
                    break;
                case 'L' :
                    turnL();
                    break;
                case 'R' :
                    turnR();
                    break;
                default:
                    throw new Exception();
            }
        }
        return x + " " + y + " " + p;
    }

    private static void move () throws Exception {
        switch (p) {
            case 'E' :
                x = x + 1;
                break;
            case 'S' :
                y = y - 1;
                break;
            case 'W' :
                x = x - 1;
                break;
            case 'N' :
                y = y + 1;
                break;
            default:
                throw new Exception();
        }
    }

    private static void turnL () throws Exception {
        switch (p) {
            case 'E' :
                p = 'N';
                break;
            case 'S' :
                p = 'E';
                break;
            case 'W' :
                p = 'S';
                break;
            case 'N' :
                p = 'W';
                break;
            default:
                throw new Exception();
        }

    }

    private static void turnR () throws Exception {
        switch (p) {
            case 'E' :
                p = 'S';
                break;
            case 'S' :
                p = 'W';
                break;
            case 'W' :
                p = 'N';
                break;
            case 'N' :
                p = 'E';
                break;
            default:
                throw new Exception();
        }

    }

}
