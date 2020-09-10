package org.kodluyoruz.trendyol.model.dto;

import org.kodluyoruz.trendyol.model.Company;
import org.kodluyoruz.trendyol.model.Message;

public class MessageSendDTO {
    private Company company;
    private Message message;
    private String nameOfUser;

    public MessageSendDTO(Company company, Message message, String nameOfUser) {
        this.company = company;
        this.message = message;
        this.nameOfUser = nameOfUser;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getNameOfUser() {
        return nameOfUser;
    }

    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }
}
