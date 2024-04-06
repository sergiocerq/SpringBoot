package org.applications.beanscope.lesson1.entities;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.apache.juli.logging.Log;
import org.applications.beanscope.lesson1.interfaces.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ContentBasedFilter implements Filter {

    private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    private static int instances = 0;

    @Autowired
    private Movie movie;
    @PostConstruct
    private void postConstruct() {
        //load movies into cache
        logger.info("In ContentBasedFilter postConstruct method");
    }

    @PreDestroy
    private void preDestroy() {
        //clear movies from cache
        logger.info("In ContentBasedFilter preDestroy method");
    }


    public ContentBasedFilter() {
        instances++;
        System.out.println("ContentBasedFilter constructor called");
    }

    public Movie getMovie() {
        return movie;
    }

    public static int getInstances() {
        return ContentBasedFilter.instances;
    }

    //getRecommendations takes a movie as input and returns a list of similar movies
    public String[] getRecommendations(String movie) {
        //calculate similarity between movies
        //return movie recommendations
        return new String[]{"1st Movie", "2nd Movie", "3rd Movie"};
    }
}