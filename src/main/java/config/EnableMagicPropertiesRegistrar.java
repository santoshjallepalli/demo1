package config;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.bind.PropertySourcesPropertyValues;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.validation.DataBinder;

import java.util.Map;

class EnableMagicPropertiesRegistrar
        implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    private ConfigurableEnvironment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = (ConfigurableEnvironment) environment;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata,
                                        BeanDefinitionRegistry registry) {
        ConfigurableListableBeanFactory beanFactory = (ConfigurableListableBeanFactory) registry;
        Map<String, Object> attributes = metadata
                .getAnnotationAttributes(EnableMagicProperties.class.getName());
        Class<?> type = (Class<?>) attributes.get("value");
        beanFactory.registerSingleton(type.getName(), createAndBind(type));
    }

    private Object createAndBind(Class<?> type) {
        Object instance = BeanUtils.instantiate(type);
        bind(instance);
        return instance;
    }

    private void bind(Object instance) {
        MutablePropertySources propertySources = this.environment.getPropertySources();
        PropertySourcesPropertyValues propertyValues = new PropertySourcesPropertyValues(
                propertySources);
        DataBinder binder = new DataBinder(instance);
        binder.bind(propertyValues);
    }

}