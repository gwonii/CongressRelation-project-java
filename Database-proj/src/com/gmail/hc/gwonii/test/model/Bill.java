package com.gmail.hc.gwonii.test.model;

public class Bill {

    private int id;
    private String name;
    private String date;
    private int agencyId;

    public Bill(int id, String name, String date, int agencyId) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.agencyId = agencyId;
    }
}
