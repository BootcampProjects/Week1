package org.kodluyoruz.trendyol.constant;

public class ErrorMessage {

    private static String[] messageLimitErrorMessage = {
            "Message Limit Error",   // 0 -> default
            "Mesaj limiti aşıldı",   // 1 -> TR
            "Message limit exceeded" // 2 -> EN
    };

    public static String messageLimitException(int languageIndex) {
        return messageLimitErrorMessage[languageIndex];
    };

}
