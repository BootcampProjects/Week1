package Business;

import Models.Message;
import Models.User;

public class SmsAndEmailSender implements ISender {
    @Override
    public boolean Send(User user, Message message) {
        if (user.getSmsCount() < 1000 && user.getEmailCount() < 10000) {

            // sending operations

            user.setSmsCount(user.getSmsCount() + 1);
            user.setEmailCount(user.getEmailCount() + 1);

            System.out.println(user.getName() + " sent SMS & Email -> " + message.getSentTo().getName() + " - " + message.getContent() + " - SMS Count : " + user.getSmsCount() + " - Email Count : " + user.getEmailCount());

            return true;
        }
        System.out.println("**** OOPS! " + user.getName() + " exceed the SMS or email limit.");
        return false;
    }
}
