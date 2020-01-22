package org.sample.capstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AccountsApplication {

   @Bean
    public HealthIndicator dbHealthIndicator() {
        return new HealthIndicator() {

            @Override
            public Health health() {
                return Health.status(Status.UP).withDetail("hello", "hi").build();
            }
        };
    }
   
    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }
    
   @RestController
    public class HelloController {
        @GetMapping("/hello")
        public String hello() {
            return "hello";
        }
    }
}