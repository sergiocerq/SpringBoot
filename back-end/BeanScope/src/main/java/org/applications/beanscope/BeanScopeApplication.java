package org.applications.beanscope;

import org.apache.catalina.core.ApplicationContext;
import org.applications.beanscope.entities.ContentBasedFilter;
import org.applications.beanscope.entities.Movie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//Application context that has a bean with a singleton scope (1 per application),
//but its dependencies have the prototype scope (1+ per application).
//The ContentBasedFilter has singleton, but the movies of the content-based-filter have prototype scope.
public class BeanScopeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(BeanScopeApplication.class, args);
        ContentBasedFilter contentBasedFilter = applicationContext.getBean(ContentBasedFilter.class);
        System.out.println("Content based filter created with the singleton scope!");
        System.out.println(contentBasedFilter);

        Movie movie1 = contentBasedFilter.getMovie();
        Movie movie2 = contentBasedFilter.getMovie();
        Movie movie3 = contentBasedFilter.getMovie();

        System.out.println("\nMovie bean with prototype scope");
        System.out.println(movie1);
        System.out.println(movie2);
        System.out.println(movie3);
        System.out.println("\nContentBasedFilter instances created: "+ ContentBasedFilter.getInstances());
        System.out.println("Movie instances created: "+ Movie.getInstances());
    
    }

}
