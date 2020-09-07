package Tests;

import Business.EmailSender;
import Models.Message;
import Models.User;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class EmailSenderTest {

    EmailSender emailSender;
    User user1, user2;
    Message messageUser1;


    @BeforeEach
    public void setUp() {
        emailSender = new EmailSender();

        user1 = new User("User1");
        user2 = new User("User2");

        messageUser1 = new Message("Test Message", user2);
    }

    @Test
    public void it_should_return_true() {
        // Given
        // done beforeEach

        // When
        boolean result = user1.SendMessage(emailSender, messageUser1);

        // Then
        Assert.assertEquals(true, result);
    }
}