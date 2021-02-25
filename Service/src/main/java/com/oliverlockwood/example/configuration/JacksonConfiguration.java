package com.ooyala.flex.search.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
//import org.springframework.integration.support.json.JsonObjectMapper;

import java.text.SimpleDateFormat;


@Configuration
public class JacksonConfiguration {

    /**
     * Returns a mapper configured to ignore unknown properties.
     *
     * @return {@link ObjectMapper} with properties set.
     */
    @Bean
    public ObjectMapper objectMapper() {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        return objectMapper;
    }


//    @Bean
//    public JsonObjectMapper jsonObjectMapper() {
//
//        return new Jackson2JsonObjectMapper(objectMapper());
//    }
}
