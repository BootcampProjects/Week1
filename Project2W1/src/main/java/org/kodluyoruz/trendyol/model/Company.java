package org.kodluyoruz.trendyol.model;

import org.kodluyoruz.trendyol.business.EmailSender;
import org.kodluyoruz.trendyol.business.SmsSender;
import org.kodluyoruz.trendyol.model.dto.MessageSendDTO;

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

    public void SendSms(Sms sms, User user) {
        SmsSender smsSender = new SmsSender(); // TODO : singleton

        MessageSendDTO messageSendDTO = new MessageSendDTO(this, sms, user.getName());

        smsSender.Send(messageSendDTO);
    }

    public void SendEmail(Email email, User user) {
        EmailSender emailSender = new EmailSender();

        MessageSendDTO messageSendDTO = new MessageSendDTO(this, email, user.getName());

        emailSender.Send(messageSendDTO);
    }
}
