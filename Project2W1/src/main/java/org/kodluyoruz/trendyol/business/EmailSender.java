package org.kodluyoruz.trendyol.business;

import org.kodluyoruz.trendyol.exception.MessageLimitException;
import org.kodluyoruz.trendyol.model.Company;
import org.kodluyoruz.trendyol.model.Email;
import org.kodluyoruz.trendyol.model.dto.MessageSendDTO;

public class EmailSender implements MessageSender {
    private static EmailSender instance = null;

    private EmailSender() {
    }

    public static EmailSender getInstance() {
        if (instance == null)
            instance = new EmailSender();

        return instance;
    }

    @Override
    public void Send(MessageSendDTO messageSendDTO) {
        Company company = messageSendDTO.getCompany();
        Email email = (Email) messageSendDTO.getMessage();

        if (company.getEmailLimit() > 0) {
            company.setEmailLimit(company.getEmailLimit() - 1);
            System.out.println(company.getName() +
                    " - sent Email -> " + messageSendDTO.getNameOfUser() +
                    " - subject : " + email.getSubject() +
                    " - content : " + email.getContent() +
                    " - remaining Email limit : " + company.getEmailLimit());
        } else {
            System.out.println("OOPS! " + company.getName() +
                    " - exceeded Email limit" + company.getEmailLimit());
            throw new MessageLimitException();
        }

    }
}
