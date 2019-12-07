package com.gmail.hc.gwonii.test.model;

public class Result {

    private int agreeCount;
    private int disagreeCount;
    private int abstentionCount;
    private String votingResult;

    public Result(int agreeCount, int disagreeCount, int abstentionCount, String votingResult) {
        this.agreeCount = agreeCount;
        this.disagreeCount = disagreeCount;
        this.abstentionCount = abstentionCount;
        this.votingResult = votingResult;
    }


}
