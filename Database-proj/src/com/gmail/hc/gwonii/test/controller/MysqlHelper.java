package com.gmail.hc.gwonii.test.controller;

import java.sql.*;

public class MysqlHelper {

    public static Connection conn = null;

    public static void setMysql() {
        try {

            String url = "jdbc:mysql://127.0.0.1:3306/testdb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";

            conn = DriverManager.getConnection(url, "gwonii", "Gysid1256!");

            System.out.println(conn.toString());

        } catch (SQLException e) {
            System.out.println("SQLException" + e.getMessage());
            System.out.println("SQLState" + e.getSQLState());
            System.out.println("VendorError" + e.getErrorCode());
        }
    }
}
