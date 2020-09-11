package org.kodluyoruz.trendyol.business;

import org.kodluyoruz.trendyol.constant.ErrorMessage;
import org.kodluyoruz.trendyol.exception.MessageLimitException;
import org.kodluyoruz.trendyol.model.Company;
import org.kodluyoruz.trendyol.model.Sms;
import org.kodluyoruz.trendyol.model.dto.MessageSendDTO;

public class SmsSender implements MessageSender {
    private static SmsSender instance = null;

    private SmsSender() {
    }

    public static SmsSender getInstance() {
        if (instance == null)
            instance = new SmsSender();

        return instance;
    }

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
            System.out.println("OOPS! " + company.getName() +
                    " - exceeded SMS limit : " + company.getSmsLimit());
            throw new MessageLimitException(ErrorMessage.messageLimitException(company.getLanguage()));
        }
    }
}
