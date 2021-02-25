package com.oliverlockwood.example.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@ApiModel
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExampleRequest {

    private static final int DEFAULT_LIMIT = 25;

    @ApiParam(value = "The ID of the user", required = true)
    @Min(1)
    @NotNull
    private long userId;

    @ApiParam(value = "The search result page number", defaultValue = "0")
    @Min(0)
    private int page;

    @ApiParam(value = "The search result page size", defaultValue = "" + DEFAULT_LIMIT)
    @Min(1)
    @Max(500)
    @Builder.Default
    private int limit = DEFAULT_LIMIT;

}
