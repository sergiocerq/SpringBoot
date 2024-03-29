package org.applications.beanscope.lesson1.entities;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.applications.beanscope.lesson1.interfaces.Filter;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class RecommenderImplementation {

    private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    private Filter filter;

    @PostConstruct
    public void postConstruct() {
        logger.info("Construct in the ReccomenderImplementation");
    }

    @PreDestroy
    public void destroy() {
        logger.info("Destroying the RecommenderImplementation bean");
    }

    @Autowired
    public void setFilter(Filter filter) {
        logger.info("In RecommendationImplementation setter method, applied the Dependency Injection...");
        this.filter = filter;
    }
}
