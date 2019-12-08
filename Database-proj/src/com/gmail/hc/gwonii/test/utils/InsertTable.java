package com.gmail.hc.gwonii.test.utils;

import com.gmail.hc.gwonii.test.controller.MysqlHelper;
import com.gmail.hc.gwonii.test.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTable {
//
//    INSERT INTO 테이블명
//    VALUES (전체 COLUMN에 넣을 VALUE_LIST);
//
//    INSERT INTO PLAYER
//    VALUES ('2002007', ' 박지성', 'K07', 'MF' ,178, 73, 7);

    public static void insertAgencyTable(AgencyList agencyList) {
        ResultSet rs = null;
        Statement stmt = null;
        String sql = "";

        try {
            stmt = MysqlHelper.conn.createStatement();

            for (int i = 0; i < agencyList.getData().size(); i++) {
                sql = "INSERT INTO agency VALUES ('" + agencyList.getData().get(i).getCommitteeCode() + "', '" + agencyList.getData().get(i).getCommitteeName() + "')";
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertBillTable(BillList billList) {
        ResultSet rs = null;
        Statement stmt = null;
        String sql = null;

        sql = "";

        try {
            stmt = MysqlHelper.conn.createStatement();

            for (int i = 0; i < billList.getData().size(); i++) {
                sql = "INSERT INTO bill VALUES ('" + billList.getData().get(i).getBillCode() + "'," +
                        " '" + billList.getData().get(i).getBillName() + "'," +
                        " '" + billList.getData().get(i).getProcessDate() + "',"+
                        " '" + billList.getData().get(i).getCommitteeName() + "')";
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void insertCongressmanTable(CongressmanList congressmanList) {
        ResultSet rs = null;
        Statement stmt = null;
        String sql = null;

        sql = "";

        try {
            stmt = MysqlHelper.conn.createStatement();

            for (int i = 0; i < congressmanList.getData().size(); i++) {
                sql = "INSERT INTO congressman VALUES ('" + congressmanList.getData().get(i).getCongressManCode() + "'," +
                        " '" + congressmanList.getData().get(i).getCongressManName() + "'," +
                        " '" + congressmanList.getData().get(i).getRegion() + "',"+
                        " '" + congressmanList.getData().get(i).getParty() + "',"+
                        " '" + congressmanList.getData().get(i).getCommitteeName() + "')";
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertResultTable(BillList billList) {
        ResultSet rs = null;
        Statement stmt = null;
        String sql = null;

        sql = "";

        try {
            stmt = MysqlHelper.conn.createStatement();

            for (int i = 0; i < billList.getData().size(); i++) {
                sql = "INSERT INTO result VALUES ('" + billList.getData().get(i).getBillCode() + "'," +
                        " '" + billList.getData().get(i).getAgree() + "'," +
                        " '" + billList.getData().get(i).getWithdraw() + "',"+
                        " '" + billList.getData().get(i).getDisagree() + "',"+
                        " '" + billList.getData().get(i).getBillResult() + "')";
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertConfirmTable(ConfirmList confirmList) {
        ResultSet rs = null;
        Statement stmt = null;
        String sql = null;

        sql = "";

        try {
            stmt = MysqlHelper.conn.createStatement();

            for (int i = 0; i < confirmList.getData().size(); i++) {
                sql = "INSERT INTO confirm VALUES ('" + confirmList.getData().get(i).getCongressManCode() + "'," +
                        " '" + confirmList.getData().get(i).getBillCode() + "'," +
                        " '" + confirmList.getData().get(i).getResultVote() + "')";
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


   //bill 에 bill과 result를 만들어야함

    //        MysqlHelper.setMysql();
//
//        ResultSet rs = null;
//        Statement stmt = null;
//
//        String sql = "SELECT name FROM bill";
//
//        try {
//            stmt = MysqlHelper.conn.createStatement();
//            rs = stmt.executeQuery(sql);
//
//            while(rs.next()){
//                // 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작한다.
//                // 데이터베이스에서 가져오는 데이터의 타입에 맞게 getString 또는 getInt 등을 호출한다.
//                String name = rs.getString(1);
//                System.out.println(""+name + "\n");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
}
