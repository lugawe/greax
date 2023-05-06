package org.greax.core.messaging;

public interface Handler {

    ResponsePacket handle(RequestPacket requestPacket) throws Exception;

}
