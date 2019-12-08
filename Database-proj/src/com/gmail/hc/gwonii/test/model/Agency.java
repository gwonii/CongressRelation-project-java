package com.gmail.hc.gwonii.test.model;

public class Agency {

    private String committeeCode;
    private String committeeName;

    public String getCommitteeCode() {
        return committeeCode;
    }

    public String getCommitteeName() {
        return committeeName;
    }

    @Override
    public String toString() {
        return "Agency{" +
                "committeeCode='" + committeeCode + '\'' +
                ", committeeName='" + committeeName + '\'' +
                '}';
    }
}
