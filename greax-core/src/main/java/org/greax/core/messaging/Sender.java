package org.greax.core.messaging;

import java.io.Serializable;
import java.util.UUID;

public interface Sender extends Serializable {

    enum Type {
        SERVER, CLIENT
    }

    Type getType();

    UUID getId();

}
