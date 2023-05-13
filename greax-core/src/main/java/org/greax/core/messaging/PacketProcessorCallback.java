package org.greax.core.messaging;

import com.google.common.util.concurrent.FutureCallback;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import org.greax.core.messaging.packets.EmptyPacket;
import org.greax.core.messaging.packets.ThrowablePacket;
import org.greax.core.util.ExceptionUtils;

import java.util.Objects;

public class PacketProcessorCallback implements FutureCallback<Packet> {

    protected final Message receivedMessage;

    public PacketProcessorCallback(Message receivedMessage) {
        this.receivedMessage = Objects.requireNonNull(receivedMessage, "receivedMessage");
        acknowledge();
    }

    protected void acknowledge() {
        try {
            receivedMessage.acknowledge();
        } catch (JMSException e) {
            throw ExceptionUtils.sneakyThrow(e);
        }
    }

    protected void sendReply(Packet packet) {
        // todo
    }

    @Override
    public void onSuccess(Packet packet) {
        sendReply(packet != null ? packet : EmptyPacket.getInstance());
    }

    @Override
    public void onFailure(Throwable throwable) {
        sendReply(new ThrowablePacket(throwable));
    }

}
