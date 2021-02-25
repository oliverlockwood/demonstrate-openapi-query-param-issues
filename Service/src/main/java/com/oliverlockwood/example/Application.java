package com.oliverlockwood.example;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


@SpringBootApplication(scanBasePackages = "com.oliverlockwood")
@EnableConfigurationProperties
@Slf4j
public class Application extends SpringApplication {

    @Value("${info.app-name}")
    private String appName;

    @Value("${info.description}")
    private String appDescription;

    @Value("${info.version}")
    private String version;


    public static void main(String[] args) {

        log.debug("Starting Example service");
        Application.run(Application.class, args);
        log.debug("Example service is running...");
    }


    @Bean
    public OpenAPI api() {

        return new OpenAPI()
                .info(apiInfo());
    }


    private Info apiInfo() {

        return new Info()
                .title(appName)
                .description(appDescription)
                .version(version)
                .contact(new Contact().name("Oliver Lockwood").url("https://www.oliverlockwood.com/"));
    }

}
