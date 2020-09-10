package org.kodluyoruz.trendyol;

import org.kodluyoruz.trendyol.business.EmailSender;
import org.kodluyoruz.trendyol.business.SmsSender;
import org.kodluyoruz.trendyol.model.Company;
import org.kodluyoruz.trendyol.model.Email;
import org.kodluyoruz.trendyol.model.Sms;
import org.kodluyoruz.trendyol.model.User;
import org.kodluyoruz.trendyol.model.dto.MessageSendDTO;

public class SenderApp {
    public static void main(String[] args) {
        SmsSender smsSender = new SmsSender();
        EmailSender emailSender = new EmailSender();

        Company company1 = new Company("Comp1");
        Company company2 = new Company("Comp2");

        User user1 = new User("User1");
        User user2 = new User("User2");

        Sms sms = new Sms("Hi");
        Email email = new Email("Hello", "Greeting");

        MessageSendDTO messageSendDTO1 = new MessageSendDTO(company1, sms, user1.getName());
        MessageSendDTO messageSendDTO2 = new MessageSendDTO(company2, email, user2.getName());

        smsSender.Send(messageSendDTO1);
        emailSender.Send(messageSendDTO2);
    }
}
