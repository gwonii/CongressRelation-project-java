package com.gmail.hc.gwonii.test;

import com.gmail.hc.gwonii.test.controller.MysqlHelper;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        MysqlHelper.setMysql();

        ResultSet rs = null;
        Statement stmt = null;

        String sql = "SELECT name FROM bill";

        try {
            stmt = MysqlHelper.conn.createStatement();
            rs = stmt.executeQuery(sql);

            while(rs.next()){
                // 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작한다.
                // 데이터베이스에서 가져오는 데이터의 타입에 맞게 getString 또는 getInt 등을 호출한다.
                String name = rs.getString(1);
                System.out.println(""+name + "\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }













    }

    public void Insert() {

    }

    public void selectQuery() {

    }


}


