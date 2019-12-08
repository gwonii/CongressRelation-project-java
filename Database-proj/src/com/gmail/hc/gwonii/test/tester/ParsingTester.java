package com.gmail.hc.gwonii.test.tester;

import com.gmail.hc.gwonii.test.controller.MysqlHelper;
import com.gmail.hc.gwonii.test.model.*;
import com.gmail.hc.gwonii.test.utils.InsertTable;
import com.gmail.hc.gwonii.test.utils.ParsingUtil;

import java.io.File;

import static com.gmail.hc.gwonii.test.utils.InsertTable.*;

public class ParsingTester extends Thread {

    private BillList billList;
    private AgencyList agencyList;
    private CongressmanList congressmanList;
    private ConfirmList confirmList;
    private BillList resultList;

    @Override
    public void run() {
        super.run();

        MysqlHelper.setMysql();

        billList = new BillList();
        agencyList = new AgencyList();
        congressmanList = new CongressmanList();
        confirmList = new ConfirmList();
        resultList = new BillList();

        System.out.println("bill----------------------------------------------------");

//        File billFile = new File("./asset/bill.json");
//        billList = ParsingUtil.billParsing(billFile);
//
//        insertBillTable(billList);

        System.out.println("agency----------------------------------------------------");

//        File agencyFile = new File("./asset/agency.json");
//        agencyList = ParsingUtil.agencyParsing(agencyFile);
//
//        InsertTable.insertAgencyTable(agencyList);

        System.out.println("congressman----------------------------------------------------");

//        File congressmanFile = new File("./asset/congressMan.json");
//        congressmanList = ParsingUtil.congressmanParsing(congressmanFile);
//
//        insertCongressmanTable(congressmanList);

        System.out.println("confirm----------------------------------------------------");

        File confirmFile = new File("./asset/confirm.json");
        confirmList = ParsingUtil.confirmParsing(confirmFile);

        insertConfirmTable(confirmList);

        System.out.println("result----------------------------------------------------");

//        File resultFile = new File("./asset/bill.json");
//        resultList = ParsingUtil.billParsing(resultFile);
//
//        insertResultTable(resultList);
    }
}
