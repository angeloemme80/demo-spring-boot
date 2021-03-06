/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.angelomassaro.demospringboot;

import it.angelomassaro.cdi.SessionData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.annotation.SessionScope;

/**
 *
 * @author admwks
 */
@SpringBootApplication
@ComponentScan(basePackages = { "it.angelomassaro.controller", "it.angelomassaro.restcontroller", "it.angelomassaro.demospringboot","it.angelomassaro.cdi"} )
public class Application {
  
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
   @Bean
   @SessionScope
   public SessionData sessionData() {
      return new SessionData();
   }
   
    /*
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }
    */
    
}
