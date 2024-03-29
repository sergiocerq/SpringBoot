package org.applications.beanscope.entities;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Movie {

    private static Integer instances = 0;

    private Integer id;
    private String name;
    private String genre;
    private String producer;

    public Movie() {
        instances ++;
        System.out.println("Constructor called, with " + Movie.instances + " instances");
    }

    public static Integer getInstances() {
        return Movie.instances;
    }

}
