package org.kodluyoruz.trendyol;

import org.kodluyoruz.trendyol.model.Company;
import org.kodluyoruz.trendyol.model.Email;
import org.kodluyoruz.trendyol.model.Sms;
import org.kodluyoruz.trendyol.model.User;

public class SenderApp {
    public static void main(String[] args) {
        Company company1 = new Company("Comp1");
        Company company2 = new Company("Comp2");

        User user1 = new User("User1");
        User user2 = new User("User2");

        Sms sms = new Sms("Hi");
        Email email = new Email("Hello", "Greeting");

        company1.SendSms(sms, user1);
        company1.SendEmail(email, user1);
        company2.SendEmail(email, user2);
    }
}
