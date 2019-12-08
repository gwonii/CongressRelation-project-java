package com.gmail.hc.gwonii.test.utils;

import com.gmail.hc.gwonii.test.controller.MysqlHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryUtil {

    public static void selectName(String congressManCode) {
        ResultSet rs = null;
        Statement stmt = null;
        String sql = null;

        try {
            stmt = MysqlHelper.conn.createStatement();

            sql = "select congressManName\n" +
                    "from congressman\n" +
                    "where congressManCode = " + "\"" + congressManCode + "\"";
            rs = stmt.executeQuery(sql);

            while(rs.next()){
                // 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작한다.
                // 데이터베이스에서 가져오는 데이터의 타입에 맞게 getString 또는 getInt 등을 호출한다.
                String name = rs.getString(1);
                System.out.println(name + " 님과의 정책유사도 리스트");
                System.out.println("+-------------------------+");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // congressManCode 입력
    public static void createTempTable(String congressManCode) {
        ResultSet rs = null;
        Statement stmt = null;
        String sql = null;

        sql = "";

        try {
            stmt = MysqlHelper.conn.createStatement();

            sql = "DROP TABLE IF EXISTS temp";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE `aplus`.`temp` (`congressManCode` VARCHAR(100) NOT NULL," +
                    "\nPRIMARY KEY (`congressManCode`))";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO temp VALUES (" + congressManCode + ")";
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 친밀도 쿼리
    public static void queryIntimacy(String congressManCode) {

        ResultSet rs = null;
        Statement stmt = null;
        String sql = null;

        try {
            stmt = MysqlHelper.conn.createStatement();

            sql = "SELECT confirm.congressManCode, congressman.congressManName, count(confirm.congressManCode)\n" +

                    "FROM (select confirm.congressManCode, billCode\n" +
                    "\t  from confirm , temp\n" +
                    "\t  where temp.congressManCode = confirm.congressManCode\n" +
                    "\t  AND resultVote = '찬성') step, confirm, congressman\n" +

                    "WHERE confirm.billCode = step.billCode\n" +
                    "AND confirm.congressManCode = congressman.congressManCode\n" +
                    "AND confirm.resultVote = '찬성'\n" +
                    "AND confirm.congressManCode <> \"" + congressManCode + "\"\n" +
                    "group by confirm.congressManCode\n" +
                    "order by count(confirm.congressManCode) DESC";

            rs = stmt.executeQuery(sql);

            while(rs.next()){
                // 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작한다.
                // 데이터베이스에서 가져오는 데이터의 타입에 맞게 getString 또는 getInt 등을 호출한다.
                String code = rs.getString(1);
                String name = rs.getString(2);
                int count = rs.getInt(3);
                System.out.println(""+code + "\t|\t" + name + "\t|\t" + count);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


//        try {
//            stmt = MysqlHelper.conn.createStatement();
//
//            for (int i = 0; i < confirmList.getData().size(); i++) {
//                sql = "INSERT INTO confirm VALUES ('" + confirmList.getData().get(i).getCongressManCode() + "'," +
//                        " '" + confirmList.getData().get(i).getBillCode() + "'," +
//                        " '" + confirmList.getData().get(i).getResultVote() + "')";
//                stmt.executeUpdate(sql);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }

    // 지역구
    public static void queryDistrict(String inputRegion) {
        ResultSet rs = null;
        Statement stmt = null;
        String sql = null;

        try {
            stmt = MysqlHelper.conn.createStatement();

            sql = "select confirm.billCode, region, count(region)\n" +
                    "from ( select congressman.congressManCode, region\n" +
                    "\t  from congressman\n" +
                    "\t  where region like" + "\"%" + inputRegion + "%\"" + ")step, confirm\n" +
                    "where step.congressManCode = confirm.congressManCode\n" +
                    "AND confirm.resultVote = \"찬성\"\n" +
                    "group by confirm.billCode\n" +
                    "order by count(confirm.billCode) DESC";

            rs = stmt.executeQuery(sql);

            while(rs.next()){
                // 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작한다.
                // 데이터베이스에서 가져오는 데이터의 타입에 맞게 getString 또는 getInt 등을 호출한다.
                String code = rs.getString(1);
                String region = rs.getString(2);
                int count = rs.getInt(3);
                System.out.println(""+code + "\t|\t" + region + "\t|\t" + count);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 의원 리스트
    public static void queryManList() {

        ResultSet rs = null;
        Statement stmt = null;
        String sql = null;

        try {
            stmt = MysqlHelper.conn.createStatement();

            sql = "select * from congressManList";
            rs = stmt.executeQuery(sql);

            while(rs.next()){
                // 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작한다.
                // 데이터베이스에서 가져오는 데이터의 타입에 맞게 getString 또는 getInt 등을 호출한다.
                String code = rs.getString(1);
                String name = rs.getString(2);
                String region = rs.getString(3);
                String party = rs.getString(4);
                String committeeName = rs.getString(5);
                System.out.println(""+code + "\t|\t" + name + "\t|\t" + region + "\t|\t" + party + "\t|\t" + committeeName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // 법안 리스트
    public static void queryBillList() {
        ResultSet rs = null;
        Statement stmt = null;
        String sql = null;

        try {
            stmt = MysqlHelper.conn.createStatement();

            sql = "select * from billList";
            rs = stmt.executeQuery(sql);

            while(rs.next()){
                // 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작한다.
                // 데이터베이스에서 가져오는 데이터의 타입에 맞게 getString 또는 getInt 등을 호출한다.
                String code = rs.getString(1);
                String name = rs.getString(2);
                String date = rs.getString(3);
                String committeeName = rs.getString(4);
                System.out.println(""+code + "\t|\t" + name + "\t|\t" + date + "\t|\t" + committeeName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
