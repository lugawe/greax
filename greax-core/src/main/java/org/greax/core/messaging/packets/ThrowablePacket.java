package org.greax.core.messaging.packets;

import org.greax.core.messaging.Packet;

import java.util.Objects;

public class ThrowablePacket implements Packet {

    protected Throwable throwable;

    public ThrowablePacket(Throwable throwable) {
        this.throwable = throwable;
    }

    public ThrowablePacket() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ThrowablePacket)) return false;
        ThrowablePacket that = (ThrowablePacket) o;
        return Objects.equals(throwable, that.throwable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(throwable);
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

}
