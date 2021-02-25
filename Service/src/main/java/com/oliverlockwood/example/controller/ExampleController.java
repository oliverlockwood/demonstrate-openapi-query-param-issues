package com.oliverlockwood.example.controller;

import com.oliverlockwood.example.contract.ExampleContract;
import com.oliverlockwood.example.model.request.ExampleRequest;
import com.oliverlockwood.example.model.response.ExampleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static java.lang.String.format;


@RestController
@Api("Example")
public class ExampleController implements ExampleContract {


    @ApiOperation("This is the Example Api")
    @Override
    public ExampleResponse example(@Valid @ModelAttribute ExampleRequest exampleRequest) {

        String responseString = format("Requested userId:%d, page:%d, limit:%d",
                exampleRequest.getUserId(), exampleRequest.getPage(), exampleRequest.getLimit());

        return new ExampleResponse(responseString);
    }

}
