package org.greax.core.util;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.ObjectMessage;
import org.greax.core.messaging.InvalidMessageException;
import org.greax.core.messaging.Packet;

import java.io.Serializable;

public final class MessageUtils {

    private MessageUtils() {
    }

    public static Packet extract(Message message) throws InvalidMessageException, JMSException {
        if (message instanceof ObjectMessage) {
            ObjectMessage objectMessage = (ObjectMessage) message;
            Serializable serializable = objectMessage.getObject();
            if (serializable instanceof Packet) {
                return (Packet) serializable;
            } else {
                throw new InvalidMessageException(message, "object message does not contain packet");
            }
        } else {
            throw new InvalidMessageException(message, "message is null or not an object message");
        }
    }

}
