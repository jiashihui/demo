package com.example.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {

    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String URL = "jdbc:sqlserver://192.168.10.54:1433;DatabaseName=jxfxqdev";
            Connection conn = DriverManager.getConnection(URL, "jxfxqdev", "transino");
            System.out.println("连接数据库成功");
            conn.close();
        }catch(Exception e){
            System.out.println("数据库连接失败");
        }
    }
}
