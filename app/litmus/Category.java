package litmus;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(value = RUNTIME)
public @interface Category {

    String value();

    int priority() default 100;

    boolean slow() default false;

}
