package example;

import com.fiestacabin.dropwizard.guice.AutoConfigService;
import com.google.inject.Guice;
import com.google.inject.Injector;
import example.template.TemplateModule;

public class HelloWorldService extends AutoConfigService<HelloWorldConfiguration> {

    public HelloWorldService() {
        super("hello-world", "example");
    }

    public static void main(String[] args) throws Exception {
        new HelloWorldService().run(args);
    }

    @Override
    protected Injector createInjector(HelloWorldConfiguration configuration) {
        return Guice.createInjector(new HelloWorldModule(configuration), new TemplateModule());
    }
}
