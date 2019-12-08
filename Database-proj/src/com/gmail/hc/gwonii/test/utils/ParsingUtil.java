package com.gmail.hc.gwonii.test.utils;

import com.gmail.hc.gwonii.test.model.AgencyList;
import com.gmail.hc.gwonii.test.model.BillList;
import com.gmail.hc.gwonii.test.model.ConfirmList;
import com.gmail.hc.gwonii.test.model.CongressmanList;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ParsingUtil {

    public static BillList billParsing(File files) {

        BillList billList = null;
        Gson gson = new Gson();

        try {

            FileReader fr = new FileReader(files);

            billList = gson.fromJson(fr, BillList.class);

            for (int i = 0; i < billList.getData().size(); i++) {
                System.out.println(billList.getData().get(i).toString());
            }

            fr.close();
        } catch (IOException e) {
            // 파일을 찾지 못한 경우
            e.printStackTrace();
        }

        return billList;
    }

    public static AgencyList agencyParsing(File files) {

        AgencyList agencyList = null;
        Gson gson = new Gson();

        try {

            FileReader fr = new FileReader(files);

            agencyList = gson.fromJson(fr, AgencyList.class);

            for (int i = 0; i < agencyList.getData().size(); i++) {
                System.out.println(agencyList.getData().get(i).toString());
            }

            fr.close();
        } catch (IOException e) {
            // 파일을 찾지 못한 경우
            e.printStackTrace();
        }

        return agencyList;
    }

    public static CongressmanList congressmanParsing(File files) {

        CongressmanList congressmanList = null;
        Gson gson = new Gson();

        try {
            FileReader fr = new FileReader(files);

            congressmanList = gson.fromJson(fr, CongressmanList.class);

            for (int i = 0; i < congressmanList.getData().size(); i++) {
                System.out.println(congressmanList.getData().get(i).toString());
            }

            fr.close();
        } catch (IOException e) {
            // 파일을 찾지 못한 경우
            e.printStackTrace();
        }

        return congressmanList;
    }

    public static ConfirmList confirmParsing(File files) {

        ConfirmList confirmList = null;
        Gson gson = new Gson();

        try {
            FileReader fr = new FileReader(files);

            confirmList = gson.fromJson(fr, ConfirmList.class);

            for (int i = 0; i < confirmList.getData().size(); i++) {
                System.out.println(confirmList.getData().get(i).toString());
            }

            fr.close();
        } catch (IOException e) {
            // 파일을 찾지 못한 경우
            e.printStackTrace();
        }

        return confirmList;
    }

}
