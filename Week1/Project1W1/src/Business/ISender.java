package Business;

import Models.Message;
import Models.User;

public interface ISender {
    public boolean Send(User user, Message message);
}
