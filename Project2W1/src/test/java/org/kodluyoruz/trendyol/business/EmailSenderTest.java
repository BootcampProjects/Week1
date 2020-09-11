package org.kodluyoruz.trendyol.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kodluyoruz.trendyol.constant.ErrorMessage;
import org.kodluyoruz.trendyol.exception.MessageLimitException;
import org.kodluyoruz.trendyol.model.Company;
import org.kodluyoruz.trendyol.model.Email;
import org.kodluyoruz.trendyol.model.User;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class EmailSenderTest {

    Company company;
    Email email;
    User user;

    @BeforeEach
    public void setUp() {
        company = new Company("Comp1", 1); // language 1 -> TR
        user = new User("User1");
        email = new Email("Email Test", "Test");
    }

    @Test
    public void it_should_send_four_email() {
        // given
        // defined fields -> BeforeEach method
        int emailLimit = company.getEmailLimit();

        // when
        company.SendEmail(email, user);
        company.SendEmail(email, user);
        company.SendEmail(email, user);
        company.SendEmail(email, user);

        // then
        assertThat(company.getEmailLimit()).isEqualTo(emailLimit - 4);
    }

    @Test
    public void it_should_throw_exception_when_email_limit_exceeded() {
        // given
        // defined fields -> BeforeEach method
        int emailLimit = company.getEmailLimit();
        for (int i = 0; i < emailLimit; i++) {
            company.SendEmail(email, user);
        }

        // when
        Throwable throwable = catchThrowable(() -> company.SendEmail(email, user));

        // then
        assertThat(throwable).isInstanceOf(MessageLimitException.class);
        assertThat(throwable).hasMessageContaining(ErrorMessage.messageLimitException(company.getLanguage()));
    }
}
