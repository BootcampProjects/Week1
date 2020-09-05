package Models;

public class Message {
    private String content;
    private User sentTo;

    public Message(String content, User sentTo) {
        this.content = content;
        this.sentTo = sentTo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getSentTo() {
        return sentTo;
    }

    public void setSentTo(User sentTo) {
        this.sentTo = sentTo;
    }
}
