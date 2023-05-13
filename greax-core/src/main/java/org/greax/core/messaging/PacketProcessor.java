package org.greax.core.messaging;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.greax.core.util.MessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.jms.Message;
import jakarta.jms.MessageListener;

import java.util.concurrent.Executors;

public abstract class PacketProcessor<T extends Packet> implements MessageListener {

    private static final Logger log = LoggerFactory.getLogger(PacketProcessor.class);

    private static final int defaultThreadPoolSize = 1;

    protected final Class<T> packetClass;
    protected final ListeningExecutorService executorService;

    public PacketProcessor(Class<T> packetClass, int nThreads) {
        this.packetClass = packetClass;
        this.executorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(nThreads));
    }

    public PacketProcessor(Class<T> packetClass) {
        this(packetClass, defaultThreadPoolSize);
    }

    @Override
    public void onMessage(Message message) {
        log.debug("onMessage");
        ListenableFuture<Packet> future = executorService.submit(() -> {
            Sender sender = MessageUtils.extractSender(message);
            T packet = MessageUtils.extractPacket(message, packetClass);
            log.debug("execute");
            return execute(sender, packet);
        });
        Futures.addCallback(future, new PacketProcessorCallback(message), executorService);
    }

    public abstract Packet execute(Sender sender, T packet) throws Exception;

}
