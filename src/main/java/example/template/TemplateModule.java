package example.template;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class TemplateModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Template.class).to(ManagedTemplate.class).in(Singleton.class);
    }
}
