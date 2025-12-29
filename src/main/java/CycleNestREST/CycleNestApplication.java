package CycleNestREST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CycleNestApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        System.out.println(">>> CycleNestApplication STARTING <<<");
        SpringApplication.run(CycleNestApplication.class, args);
        System.out.println(">>> CycleNestApplication STARTED <<<");
    }

}
