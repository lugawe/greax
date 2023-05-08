package org.greax.core.messaging;

import jakarta.jms.Message;

public class InvalidMessageException extends Exception {

    private Message jmsMessage;

    public InvalidMessageException() {
        super();
    }

    public InvalidMessageException(String message) {
        super(message);
    }

    public InvalidMessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidMessageException(Throwable cause) {
        super(cause);
    }

    public InvalidMessageException(Message jmsMessage, String message) {
        this(message);
        setJmsMessage(jmsMessage);
    }

    public Message getJmsMessage() {
        return jmsMessage;
    }

    public void setJmsMessage(Message jmsMessage) {
        this.jmsMessage = jmsMessage;
    }

}
