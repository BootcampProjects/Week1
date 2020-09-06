import Business.EmailSender;
import Business.SmsAndEmailSender;
import Business.SmsSender;
import Models.Message;
import Models.User;

public class SenderApp {
    public static void main(String[] args) {

        SmsSender smsSender = new SmsSender();
        EmailSender emailSender = new EmailSender();
        SmsAndEmailSender smsAndEmailSender = new SmsAndEmailSender();

        User user1 = new User("User1");
        User user2 = new User("User2");

        Message messageUser1 = new Message("Welcome Trendyol Bootcamp", user2);
        Message messageUser2 = new Message("Thank you :)", user1);
        Message messageUser3 = new Message("OK :)", user2);

        for (int i = 0; i < 10000; i++) {
            user1.SendMessage(emailSender, messageUser1);
        }

        user1.SendMessage(smsSender, messageUser1);
        user1.SendMessage(emailSender, messageUser1);
        user1.SendMessage(smsSender, messageUser1);
        user1.SendMessage(emailSender, messageUser1);
        user1.SendMessage(smsAndEmailSender, messageUser1);

        System.out.println("\n");

        user2.SendMessage(smsSender, messageUser2);
        user2.SendMessage(emailSender, messageUser2);
        user2.SendMessage(smsSender, messageUser2);
        user2.SendMessage(emailSender, messageUser2);
        user2.SendMessage(smsAndEmailSender, messageUser2);

        System.out.println("\n");

        user1.SendMessage(emailSender, messageUser3);
        user1.SendMessage(smsSender, messageUser3);

    }
}
