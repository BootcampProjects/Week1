package org.kodluyoruz.trendyol.business;

import org.kodluyoruz.trendyol.model.Company;
import org.kodluyoruz.trendyol.model.Message;

public interface MessageSender {
    void Send(Company company, Message message);
}
