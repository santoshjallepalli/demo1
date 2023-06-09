package config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnAClass(className = "io.undertow.Undertow")
public class UndertowConfiguration {

    @Bean
    public EmbeddedServletContainerFactory undertowContainerFactory() {
        return new UndertowEmbeddedServletContainerFactory();
    }
}