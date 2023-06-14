package cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.web.bind.annotation.RestController;

@ConfigurationPropertiesScan
@SpringBootApplication
public class Main {
    public static void main(String[] args)   {
        SpringApplication.run(Main.class, args);
    }
}
