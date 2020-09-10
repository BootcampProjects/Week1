package org.kodluyoruz.trendyol;

import org.kodluyoruz.trendyol.business.EmailSender;
import org.kodluyoruz.trendyol.business.SmsSender;
import org.kodluyoruz.trendyol.model.Company;
import org.kodluyoruz.trendyol.model.Email;
import org.kodluyoruz.trendyol.model.Sms;

public class SenderApp {
    public static void main(String[] args) {
        SmsSender smsSender = new SmsSender();
        EmailSender emailSender = new EmailSender();

        Company company1 = new Company("Comp1");
        Company company2 = new Company("Comp2");

        Sms sms = new Sms("Hi!");
        Email email = new Email("Hello", "Greeting");

        smsSender.Send(company1, sms);
        emailSender.Send(company2, email);
    }
}
