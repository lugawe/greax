package org.greax.server;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import org.greax.core.Constants;
import org.greax.core.util.Lazy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vyarus.dropwizard.guice.GuiceBundle;

public class GreaxServer extends Application<GreaxServerConfiguration> {

    private static final Logger log = LoggerFactory.getLogger(GreaxServer.class);

    private static final Lazy<GreaxServer> instance = Lazy.of(GreaxServer::new);

    public static void main(String[] args) throws Exception {
        instance.get().run(args);
    }

    @Override
    public void initialize(Bootstrap<GreaxServerConfiguration> bootstrap) {
        bootstrap.addBundle(GuiceBundle.builder().enableAutoConfig(Constants.SERVER_PACKAGE).build());
    }

    @Override
    public void run(GreaxServerConfiguration configuration, Environment environment) {
        log.info("Version: {}", Constants.VERSION);
    }

}
