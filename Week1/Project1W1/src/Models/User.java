package Models;

import Business.ISender;

public class User {
    private String name;
    private int emailCount;
    private int smsCount;

    public User(String name) {
        this.name = name;
        this.emailCount = 0;
        this.smsCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmailCount() {
        return emailCount;
    }

    public void setEmailCount(int emailCount) {
        this.emailCount = emailCount;
    }

    public int getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(int smsCount) {
        this.smsCount = smsCount;
    }

    public void SendMessage(ISender sender, Message message) {
        sender.Send(this, message);
    }
}
