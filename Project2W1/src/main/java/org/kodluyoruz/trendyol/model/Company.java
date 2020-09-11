package org.kodluyoruz.trendyol.model;

import org.kodluyoruz.trendyol.business.EmailSender;
import org.kodluyoruz.trendyol.business.SmsSender;
import org.kodluyoruz.trendyol.model.dto.MessageSendDTO;

public class Company {
    private String name;
    private int smsLimit;
    private int emailLimit;
    private int language; // 0 -> default ** 1 -> TR ** 2 -> EN

    public Company(String name, int language) {
        this.name = name;
        this.smsLimit = 1000;
        this.emailLimit = 10000;
        this.language = language;
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

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public void SendSms(Sms sms, User user) {
        SmsSender smsSender = SmsSender.getInstance();

        MessageSendDTO messageSendDTO = new MessageSendDTO(this, sms, user.getName());

        smsSender.Send(messageSendDTO);
    }

    public void SendEmail(Email email, User user) {
        EmailSender emailSender = EmailSender.getInstance();

        MessageSendDTO messageSendDTO = new MessageSendDTO(this, email, user.getName());

        emailSender.Send(messageSendDTO);
    }
}
