package com.oliverlockwood.example.contract;

import com.oliverlockwood.example.model.request.ExampleRequest;
import com.oliverlockwood.example.model.response.ExampleResponse;
import feign.RequestLine;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;


public interface ExampleContract {

    @RequestLine("GET /api/example")
    @GetMapping(value = "/api/example", produces = MediaType.APPLICATION_JSON_VALUE)
    ExampleResponse example(ExampleRequest exampleRequest);

}
