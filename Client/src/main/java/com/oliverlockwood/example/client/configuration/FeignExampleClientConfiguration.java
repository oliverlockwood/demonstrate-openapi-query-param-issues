package com.oliverlockwood.example.client.configuration;

import com.oliverlockwood.example.model.request.ExampleRequest;
import feign.codec.Encoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Feign client considers GET request as a POST when method takes POJO as a ModelAttribute.
 * https://github.com/spring-cloud/spring-cloud-netflix/issues/617
 * <p>
 * So we need to add query parameters manually in the request template.
 * <p>
 * As per https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html#spring-cloud-feign-overriding-defaults,
 * this class does not need to be annotated with {@link Configuration}; and in fact doing so would require ComponentScan
 * exclusions which it would be nicer to avoid.
 */
@Slf4j
public class FeignExampleClientConfiguration {

    @Bean
    public Encoder encoder() {

        return new AbstractRequestEncoder<ExampleRequest>();
    }

}
