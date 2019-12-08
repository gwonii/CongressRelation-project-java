package com.gmail.hc.gwonii.test.tester;

import com.gmail.hc.gwonii.test.utils.CreateTable;

import static com.gmail.hc.gwonii.test.utils.CreateTable.*;

public class CreateTester extends Thread {

    @Override
    public void run() {
        super.run();

        createAgency();
        createCongressMan();
        createBill();
        createConfirm();
        createResult();
        createCongressManList();
        createBillList();
    }
}
