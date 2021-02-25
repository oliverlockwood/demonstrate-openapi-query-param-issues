package com.oliverlockwood.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;


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
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(path -> path.matches("/api/.*"))
                .build()
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {

        return new ApiInfo(appName, appDescription, version, "", new Contact("Oliver Lockwood", "https://www.oliverlockwood.com/", null),
                null, null, Collections.emptyList());
    }

}
