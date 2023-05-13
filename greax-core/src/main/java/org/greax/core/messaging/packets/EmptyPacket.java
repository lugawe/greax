package org.greax.core.messaging.packets;

import org.greax.core.messaging.Packet;
import org.greax.core.util.Lazy;

public final class EmptyPacket implements Packet {

    private static final long serialVersionUID = 1L;

    private static final Lazy<EmptyPacket> instance = Lazy.of(EmptyPacket::new);

    private EmptyPacket() {
    }

    private Object readResolve() {
        return instance.get();
    }

    public static EmptyPacket getInstance() {
        return instance.get();
    }

}
