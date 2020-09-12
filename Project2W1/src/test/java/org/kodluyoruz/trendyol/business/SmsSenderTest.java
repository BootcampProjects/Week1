package org.kodluyoruz.trendyol.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kodluyoruz.trendyol.constant.ErrorMessage;
import org.kodluyoruz.trendyol.exception.MessageLimitException;
import org.kodluyoruz.trendyol.model.Company;
import org.kodluyoruz.trendyol.model.Sms;
import org.kodluyoruz.trendyol.model.User;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class SmsSenderTest {

    Company company;
    Sms sms;
    User user;

    @BeforeEach
    public void setUp() {
        company = new Company("Comp1", 2); // language 2 -> EN
        user = new User("User1");
        sms = new Sms("Sms Test");
    }

    @Test
    public void it_should_send_five_sms() {
        // given
        // defined fields -> BeforeEach method
        int smsLimit = company.getSmsLimit();

        // when
        company.SendSms(sms, user);
        company.SendSms(sms, user);
        company.SendSms(sms, user);
        company.SendSms(sms, user);
        company.SendSms(sms, user);

        // then
        assertThat(company.getSmsLimit()).isEqualTo(smsLimit - 5);
    }

    @Test
    public void it_should_throw_exception_when_sms_limit_exceeded() {
        // given
        // defined fields -> BeforeEach method
        int smsLimit = company.getSmsLimit();
        for (int i = 0; i < smsLimit; i++) {
            company.SendSms(sms, user);
        }

        // when
        Throwable throwable = catchThrowable(() -> company.SendSms(sms, user));

        // then
        assertThat(throwable).isInstanceOf(MessageLimitException.class);
        assertThat(throwable).hasMessageContaining(ErrorMessage.messageLimitException(company.getLanguage()));
    }
}
