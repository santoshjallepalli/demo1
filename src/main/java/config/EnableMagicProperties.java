package config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Import(EnableMagicPropertiesRegistrar.class)
public @interface EnableMagicProperties {

    Class<?> value();

}