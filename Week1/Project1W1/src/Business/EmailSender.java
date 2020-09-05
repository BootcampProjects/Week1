package Business;

import Models.Message;
import Models.User;

public class EmailSender implements ISender {
    @Override
    public boolean Send(User user, Message message) {
        if (user.getEmailCount() < 10000) {

            // sending operations

            user.setEmailCount(user.getEmailCount() + 1);

            System.out.println(user.getName() + " sent Email -> " + message.getSentTo().getName() + " - " + message.getContent() + " - Email Count : " + user.getEmailCount());
            return true;
        }
        System.out.println("**** OOPS! " + user.getName() + " exceed the email limit.");
        return false;
    }
}
