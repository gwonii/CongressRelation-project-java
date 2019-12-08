package com.gmail.hc.gwonii.test.controller;

import java.sql.*;

public class MysqlHelper {

    public static Connection conn = null;

    public static void setMysql() {
        try {

            // 구동을 시키고자 하신다면 자신의 컴퓨터 로컬 mysql db에 연동하여 사용하시기 바랍니다.
            // 연결할 db url
            String url = "jdbc:mysql://127.0.0.1:3306/aplus?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";

            // connection을 위하여 userID와 userPassword를 변경하시기 바랍니다.
            conn = DriverManager.getConnection(url, "gwonii", "Gysid1256!");

        } catch (SQLException e) {
            System.out.println("SQLException" + e.getMessage());
            System.out.println("SQLState" + e.getSQLState());
            System.out.println("VendorError" + e.getErrorCode());
        }
    }
}
