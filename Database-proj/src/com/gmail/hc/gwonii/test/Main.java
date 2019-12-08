package com.gmail.hc.gwonii.test;

import com.gmail.hc.gwonii.test.controller.MysqlHelper;
import com.gmail.hc.gwonii.test.tester.CreateTester;
import com.gmail.hc.gwonii.test.tester.ParsingTester;
import com.gmail.hc.gwonii.test.tester.QueryTester;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        MysqlHelper.setMysql();

        // 처음 실행하는 것이라면 MysqlHelper.class의 내용을 변경해주세요.
        // if first run
        // initialize
        CreateTester createTester = new CreateTester();
        createTester.start();
        createTester.join();

        ParsingTester parsingTester = new ParsingTester();
        parsingTester.start();
        parsingTester.join();



        // after initialize
        QueryTester queryTester = new QueryTester();
        queryTester.start();

    }
}


