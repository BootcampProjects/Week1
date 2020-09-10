package org.kodluyoruz.trendyol.business;

import org.kodluyoruz.trendyol.model.Company;
import org.kodluyoruz.trendyol.model.Sms;
import org.kodluyoruz.trendyol.model.dto.MessageSendDTO;

public class SmsSender implements MessageSender {
    @Override
    public void Send(MessageSendDTO messageSendDTO) {
        Company company = messageSendDTO.getCompany();
        Sms sms = (Sms) messageSendDTO.getMessage();

        if (company.getSmsLimit() > 0) {
            company.setSmsLimit(company.getSmsLimit() - 1);
            System.out.println(company.getName() +
                    " - sent SMS -> " + messageSendDTO.getNameOfUser() +
                    " - content : " + sms.getContent() +
                    " - remaining SMS limit : " + company.getSmsLimit());
        } else {
            // TODO : exception
        }
    }
}
