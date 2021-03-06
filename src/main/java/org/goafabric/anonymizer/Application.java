package org.goafabric.anonymizer;

import org.goafabric.anonymizer.crosscutting.JobControl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


/**
 * Created by amautsch on 26.06.2015.
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner init(ApplicationContext context,  JobControl job) {
        return args -> {
            job.run();
        };

    }

}
