package com.gmail.hc.gwonii.test.model;

public class Confirm {

    private String congressManCode;
    private String billCode;
    private String resultVote;

    public String getCongressManCode() {
        return congressManCode;
    }

    public String getBillCode() {
        return billCode;
    }

    public String getResultVote() {
        return resultVote;
    }

    @Override
    public String toString() {
        return "Confirm{" +
                "congressManCode='" + congressManCode + '\'' +
                ", billCode='" + billCode + '\'' +
                ", resultVote='" + resultVote + '\'' +
                '}';
    }
}
