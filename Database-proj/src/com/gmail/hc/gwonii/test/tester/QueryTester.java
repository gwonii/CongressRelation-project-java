package com.gmail.hc.gwonii.test.tester;

import com.gmail.hc.gwonii.test.controller.MysqlHelper;

import java.util.Scanner;

import static com.gmail.hc.gwonii.test.utils.QueryUtil.*;

public class QueryTester extends Thread {

    @Override
    public void run() {
        super.run();

        Scanner sc = new Scanner(System.in);
        String inputFunc = null;
        String tempCode = null;
        String tempRegion = null;

        MysqlHelper.setMysql();

//        System.out.print("의원코드를 입력해주세요 : ");
//        tempCode = sc.next();
//
//        createTempTable(tempCode);
//        selectName(tempCode);
//        queryIntimacy(tempCode);

//        System.out.print("지역을 입력해주세요 : ");
//        tempRegion = sc.next();
//        queryDistrict(tempRegion);




        while (true) {
            System.out.println("+-------------------+");
            System.out.println("1. 의원친밀도");
            System.out.println("2. 지역구별 찬반성향");
            System.out.println("3. 의원목록");
            System.out.println("4. 의안목록");
            System.out.println("5. 프로그램 설명");
            System.out.print("원하는 기능을 선택해주세요. ex) 1 or 의원친밀도 / 종료를 원하시면 0 : ");
            inputFunc = sc.next();

            if (inputFunc.equals("1") || inputFunc.equals("의원친밀도")) {
                System.out.println("\n\n");
                System.out.print("의원코드를 입력해주세요 : ");
                tempCode = sc.next();

                createTempTable(tempCode);
                selectName(tempCode);
                queryIntimacy(tempCode);

            } else if (inputFunc.equals("2") || inputFunc.equals("지역구별 찬반성향")) {
                System.out.println("\n\n");
                System.out.print("지역을 입력해주세요 : ");
                tempRegion = sc.next();
                queryDistrict(tempRegion);

            } else if (inputFunc.equals("3") || inputFunc.equals("의원목록")) {
                System.out.println("\n\n");
                queryManList();
            } else if (inputFunc.equals("4") || inputFunc.equals("의안목록")) {
                System.out.println("\n\n");
                queryBillList();
            } else if (inputFunc.equals("0")) {
                System.out.println("\n\n");
                System.out.print("프로그램을 종료합니다.");
                break;
            } else if (inputFunc.equals("5") || inputFunc.equals("프로그램 설명")) {
                System.out.println("\n\n");
                System.out.println("국회의원간의 성향 파악을 위하여 만들어진 프로그램입니다.\n");
                System.out.println("Made by Aplus_(gwonii, rak, hyun)\n\n\n");
            } else {
                System.out.println("\n\n");
                System.out.print("다시 입력해주세요.");
            }
        }
    }
}
