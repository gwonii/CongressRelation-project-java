package com.gmail.hc.gwonii.test.utils;

import com.gmail.hc.gwonii.test.controller.MysqlHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public static void createAgency() {

        ResultSet rs = null;
        Statement stmt = null;
        String sql = null;

        try {
            stmt = MysqlHelper.conn.createStatement();

            sql = "CREATE TABLE `aplus`.`agency` (\n" +
                    "  `committeeCode` VARCHAR(100) NOT NULL,\n" +
                    "  `committeeName` VARCHAR(500) NOT NULL,\n" +
                    "  PRIMARY KEY (`committeeName`)\n" +
                    ")";
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createCongressMan() {
        ResultSet rs = null;
        Statement stmt = null;
        String sql = null;

        try {
            stmt = MysqlHelper.conn.createStatement();

            sql = "CREATE TABLE `aplus`.`congressman` (\n" +
                    "  `congressManCode` VARCHAR(100) NOT NULL,\n" +
                    "  `congressManName` VARCHAR(100) NOT NULL,\n" +
                    "  `region` VARCHAR(100) NOT NULL,\n" +
                    "  `party` VARCHAR(100) NOT NULL,\n" +
                    "  `committeeName` VARCHAR(500),\n" +
                    "  PRIMARY KEY (`congressManCode`),\n" +
                    "    FOREIGN KEY (`committeeName`)\n" +
                    "    REFERENCES `aplus`.`agency` (`committeeName`)\n" +
                    "    ON DELETE SET NULL \n" +
                    ")";
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createBill() {
        ResultSet rs = null;
        Statement stmt = null;
        String sql = null;

        try {
            stmt = MysqlHelper.conn.createStatement();

            sql = "CREATE TABLE `aplus`.`bill` (\n" +
                    "  `billCode` VARCHAR(100) NOT NULL,\n" +
                    "  `billName` VARCHAR(500) NOT NULL,\n" +
                    "  `processDate` VARCHAR(100) NOT NULL,\n" +
                    "  `committeeName` VARCHAR(500) NOT NULL,\n" +
                    "  PRIMARY KEY (`billCode`, `committeeName`),\n" +
                    "\tFOREIGN KEY (`committeeName`)\n" +
                    "    REFERENCES `aplus`.`agency` (`committeeName`)\n" +
                    ")";
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createConfirm() {
        ResultSet rs = null;
        Statement stmt = null;
        String sql = null;

        try {
            stmt = MysqlHelper.conn.createStatement();

            sql = "CREATE TABLE `aplus`.`confirm` (\n" +
                    "  `congressManCode` VARCHAR(100) NOT NULL,\n" +
                    "  `billCode` VARCHAR(100) NOT NULL,\n" +
                    "  `resultVote` VARCHAR(50) NOT NULL,\n" +
                    "  PRIMARY KEY (`congressManCode`,`billCode`),\n" +
                    "    FOREIGN KEY (`congressManCode`)\n" +
                    "    REFERENCES `aplus`.`congressman` (`congressManCode`)\n" +
                    "    ON DELETE CASCADE,\n" +
                    "    FOREIGN KEY (`billCode`)\n" +
                    "    REFERENCES `aplus`.`bill` (`billCode`)\n" +
                    "  \tON DELETE CASCADE\n" +
                    ")";
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createResult() {
        ResultSet rs = null;
        Statement stmt = null;
        String sql = null;

        try {
            stmt = MysqlHelper.conn.createStatement();

            sql = "CREATE TABLE `aplus`.`result` (\n" +
                    "  `billCode` VARCHAR(100) NOT NULL,\n" +
                    "  `agree` INT NOT NULL,\n" +
                    "  `disagree` INT NOT NULL,\n" +
                    "  `withdraw` INT NOT NULL,\n" +
                    "  `billResult` VARCHAR(40) NOT NULL,\n" +
                    "  PRIMARY KEY (`billCode`),\n" +
                    "    FOREIGN KEY (`billCode`)\n" +
                    "    REFERENCES `aplus`.`bill` (`billCode`)\n" +
                    "    ON DELETE CASCADE\n" +
                    ")";
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createCongressManList() {
        ResultSet rs = null;
        Statement stmt = null;
        String sql = null;

        try {
            stmt = MysqlHelper.conn.createStatement();

            sql = "create view congressManList as\n" +
                    "select congressManCode, congressManName, region, party, committeeName\n" +
                    "from congressman";
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createBillList() {
        ResultSet rs = null;
        Statement stmt = null;
        String sql = null;

        try {
            stmt = MysqlHelper.conn.createStatement();

            sql = "create view billList as\n" +
                    "select billCode, billName, processDate, committeeName\n" +
                    "from bill";
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
