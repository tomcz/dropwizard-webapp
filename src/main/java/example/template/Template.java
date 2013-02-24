package example.template;

import com.google.common.base.Optional;

public interface Template {
    String format(Optional<String> name);
}
