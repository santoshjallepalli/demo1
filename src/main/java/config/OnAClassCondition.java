package config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

import java.util.Map;

public class OnAClassCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes = metadata
                .getAnnotationAttributes(ConditionalOnAClass.class.getName());
        String className = (String) attributes.get("className");
        return ClassUtils.isPresent(className, context.getClassLoader());
    }

}