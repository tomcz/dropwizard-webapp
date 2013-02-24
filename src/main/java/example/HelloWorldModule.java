package example;

import com.google.inject.AbstractModule;

public class HelloWorldModule extends AbstractModule {

    private final HelloWorldConfiguration configuration;

    public HelloWorldModule(HelloWorldConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    protected void configure() {
        bind(HelloWorldConfiguration.class).toInstance(configuration);
    }
}
