package com.gmail.hc.gwonii.test.model;

public class Bill {


    private String billCode;
    private String billName;
    private String processDate;
    private String committeeName;
    private int agree;
    private int withdraw;
    private int disagree;
    private String billResult;

    public String getBillCode() {
        return billCode;
    }

    public String getBillName() {
        return billName;
    }

    public String getProcessDate() {
        return processDate;
    }

    public String getCommitteeName() {
        return committeeName;
    }

    public int getAgree() {
        return agree;
    }

    public int getWithdraw() {
        return withdraw;
    }

    public int getDisagree() {
        return disagree;
    }

    public String getBillResult() {
        return billResult;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billCode='" + billCode + '\'' +
                ", billName='" + billName + '\'' +
                ", processDate='" + processDate + '\'' +
                ", committeeName='" + committeeName + '\'' +
                ", agree=" + agree +
                ", withdraw=" + withdraw +
                ", disagree=" + disagree +
                ", billResult='" + billResult + '\'' +
                '}';
    }
}
