package org.greax.core.util;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.ObjectMessage;
import org.greax.core.messaging.InvalidMessageException;
import org.greax.core.messaging.Packet;
import org.greax.core.messaging.Sender;

import java.io.Serializable;

public final class MessageUtils {

    private MessageUtils() {
    }

    public static Packet extractPacket(Message message) throws InvalidMessageException, JMSException {
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

    public static <T extends Packet> T extractPacket(Message message, Class<T> packetClass) throws InvalidMessageException, JMSException {
        Packet packet = extractPacket(message);
        if (!packetClass.isInstance(packet)) {
            throw new InvalidMessageException(message, "invalid packet type");
        }
        return packetClass.cast(packet);
    }

    public static Sender extractSender(Message message) {
        // todo
        return null;
    }

}
