package org.kodluyoruz.trendyol.model;

public class Company {
    private String name;
    private int smsLimit;
    private int emailLimit;

    public Company(String name) {
        this.name = name;
        this.smsLimit = 1000;
        this.emailLimit = 10000;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSmsLimit() {
        return smsLimit;
    }

    public void setSmsLimit(int smsLimit) {
        this.smsLimit = smsLimit;
    }

    public int getEmailLimit() {
        return emailLimit;
    }

    public void setEmailLimit(int emailLimit) {
        this.emailLimit = emailLimit;
    }
}
