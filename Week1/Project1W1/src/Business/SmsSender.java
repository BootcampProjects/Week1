package Business;

import Models.Message;
import Models.User;

public class SmsSender implements ISender {
    @Override
    public boolean Send(User user, Message message) {
        if (user.getSmsCount() < 1000) {

            // sending operations

            user.setSmsCount(user.getSmsCount() + 1);

            System.out.println(user.getName() + " sent SMS -> " + message.getSentTo().getName() + " - " + message.getContent() + " - SMS Count : " + user.getSmsCount());

            return true;
        }
        System.out.println("**** OOPS! " + user.getName() + " exceed the SMS limit.");
        return false;
    }
}
