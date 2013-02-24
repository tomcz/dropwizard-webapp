package example.resource;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.yammer.metrics.annotation.Timed;
import example.core.Saying;
import example.template.Template;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

    private final Template template;
    private final AtomicLong counter;

    @Inject
    public HelloWorldResource(Template template) {
        this.counter = new AtomicLong();
        this.template = template;
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        return new Saying(counter.incrementAndGet(), template.format(name));
    }
}
