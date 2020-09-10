package org.kodluyoruz.trendyol.business;

import org.kodluyoruz.trendyol.model.Company;
import org.kodluyoruz.trendyol.model.Message;
import org.kodluyoruz.trendyol.model.dto.MessageSendDTO;

public interface MessageSender {
    void Send(MessageSendDTO messageSendDTO);
}
