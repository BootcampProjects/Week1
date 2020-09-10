package org.kodluyoruz.trendyol.business;

import org.kodluyoruz.trendyol.model.Company;
import org.kodluyoruz.trendyol.model.Email;
import org.kodluyoruz.trendyol.model.Message;

public class EmailSender implements MessageSender {
    @Override
    public void Send(Company company, Message message) {
        Email email = (Email) message;

        if (company.getEmailLimit() > 0) {
            company.setEmailLimit(company.getEmailLimit() - 1);
            System.out.println(company.getName() + " - sent Email" +
                    " - subject : " + email.getSubject() +
                    " - content : " + email.getContent() +
                    " - remaining Email limit : " + company.getEmailLimit());
        }
        else{
            // TODO : exception
        }

    }
}
