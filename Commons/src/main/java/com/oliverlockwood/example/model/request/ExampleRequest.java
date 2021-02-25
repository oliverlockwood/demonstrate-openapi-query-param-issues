package com.oliverlockwood.example.model.request;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Schema
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExampleRequest {

    private static final int DEFAULT_LIMIT = 25;

    @Parameter(description = "The ID of the user", required = true)
    @Min(1)
    @NotNull
    private long userId;

    @Parameter(description = "The search result page number")
    @Schema(defaultValue = "0")
    @Min(0)
    private int page;

    @Parameter(description = "The search result page size")
    @Schema(defaultValue = "" + DEFAULT_LIMIT)
    @Min(1)
    @Max(500)
    @Builder.Default
    private int limit = DEFAULT_LIMIT;

}
