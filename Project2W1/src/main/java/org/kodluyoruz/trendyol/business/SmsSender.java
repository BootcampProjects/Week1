package org.kodluyoruz.trendyol.business;

import org.kodluyoruz.trendyol.model.Company;
import org.kodluyoruz.trendyol.model.Message;
import org.kodluyoruz.trendyol.model.Sms;

public class SmsSender implements MessageSender {
    @Override
    public void Send(Company company, Message message) {
        Sms sms = (Sms) message;

        if (company.getSmsLimit() > 0) {
            company.setSmsLimit(company.getSmsLimit() - 1);
            System.out.println(company.getName() + " - sent SMS" +
                    " - content : " + sms.getContent() +
                    " - remaining SMS limit : " + company.getSmsLimit());
        } else {
            // TODO : exception
        }
    }
}
