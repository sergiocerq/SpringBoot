package org.applications.beanscope.lesson1.entities;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ScopedProxyMode;

import java.util.logging.Logger;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Movie {

    private static Integer instances = 0;
    private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    private Integer id;
    private String name;
    private String genre;
    private String producer;

    public Movie() {
        instances ++;
        logger.info("Movie constructor called.");
    }

    @PostConstruct
    public void postConstruct() {
        logger.info("In the post construct method of movie class");
    }

    @PreDestroy
    public void destroy() {
        logger.info("In the pre-destroy method of the movie class.");
    }

    public static Integer getInstances() {
        return Movie.instances;
    }

}
