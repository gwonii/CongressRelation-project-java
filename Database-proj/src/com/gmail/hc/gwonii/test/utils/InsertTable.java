package com.gmail.hc.gwonii.test.utils;

import com.gmail.hc.gwonii.test.controller.MysqlHelper;
import com.gmail.hc.gwonii.test.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTable {

    public static void insertAgencyTable(AgencyList agencyList) {
        ResultSet rs = null;
        Statement stmt = null;
        String sql = null;

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

        }
    }

    public static void insertConfirmTable(ConfirmList confirmList) {
        ResultSet rs = null;
        Statement stmt = null;
        String sql = null;

        try {
            stmt = MysqlHelper.conn.createStatement();

            for (int i = 0; i < confirmList.getData().size(); i++) {
                sql = "INSERT INTO confirm VALUES ('" + confirmList.getData().get(i).getCongressManCode() + "'," +
                        " '" + confirmList.getData().get(i).getBillCode() + "'," +
                        " '" + confirmList.getData().get(i).getResultVote() + "')";
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {

        }
    }
}
