package org.greax.core.messaging;

import com.google.common.util.concurrent.FutureCallback;
import jakarta.jms.Message;

public class PacketProcessorCallback implements FutureCallback<Packet> {

    protected final Message receivedMessage;

    public PacketProcessorCallback(Message receivedMessage) {
        this.receivedMessage = receivedMessage;
    }

    @Override
    public void onSuccess(Packet packet) {

    }

    @Override
    public void onFailure(Throwable throwable) {

    }

}
