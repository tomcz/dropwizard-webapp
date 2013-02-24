package example.template;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.yammer.metrics.core.HealthCheck;

public class TemplateHealthCheck extends HealthCheck {

    private final Template template;

    @Inject
    public TemplateHealthCheck(Template template) {
        super("template");
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = template.format(Optional.of("TEST"));
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}
