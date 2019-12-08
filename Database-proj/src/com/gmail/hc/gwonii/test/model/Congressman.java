package com.gmail.hc.gwonii.test.model;

public class Congressman {

    private String congressManCode;
    private String congressManName;
    private String region;
    private String party;
    private String committeeName;

    public String getCongressManCode() {
        return congressManCode;
    }

    public String getCongressManName() {
        return congressManName;
    }

    public String getRegion() {
        return region;
    }

    public String getParty() {
        return party;
    }

    public String getCommitteeName() {
        return committeeName;
    }

    @Override
    public String toString() {
        return "Congressman{" +
                "congressManCode='" + congressManCode + '\'' +
                ", congressManName='" + congressManName + '\'' +
                ", region='" + region + '\'' +
                ", party='" + party + '\'' +
                ", committeeName='" + committeeName + '\'' +
                '}';
    }
}
