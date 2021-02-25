package com.oliverlockwood.example.client;

import com.oliverlockwood.example.client.configuration.FeignExampleClientConfiguration;
import com.oliverlockwood.example.contract.ExampleContract;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(name = "example-service", contextId = "example-api", configuration = FeignExampleClientConfiguration.class)
public interface ExampleClient extends ExampleContract {

}
