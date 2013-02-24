package example.template;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.yammer.dropwizard.lifecycle.Managed;
import example.HelloWorldConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ManagedTemplate implements Template, Managed {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final String template;
    private final String defaultName;

    @Inject
    public ManagedTemplate(HelloWorldConfiguration configuration) {
        this(configuration.getTemplate(), configuration.getDefaultName());
    }

    public ManagedTemplate(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
    }

    @Override
    public String format(Optional<String> name) {
        return String.format(template, name.or(defaultName));
    }

    @Override
    public void start() throws Exception {
        log.info("Staring ...");
    }

    @Override
    public void stop() throws Exception {
        log.info("Stopping ...");
    }
}
