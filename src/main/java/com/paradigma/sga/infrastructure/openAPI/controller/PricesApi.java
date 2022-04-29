/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.paradigma.sga.infrastructure.openAPI.controller;

import com.paradigma.sga.infrastructure.openAPI.dto.ErrorResponseRDTO;
import java.time.OffsetDateTime;
import com.paradigma.sga.infrastructure.openAPI.dto.PriceProductRDTO;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-04-29T10:04:37.636949+02:00[Europe/Paris]")
@Validated
@Api(value = "prices", description = "the prices API")
public interface PricesApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /prices : Get information about the price of a product in any enterprise of Inditex
     * Get information about the price of a product in any enterprise of Inditex in any date
     *
     * @param appDate date for apply the rate of the product (required)
     * @param productId Product identifier (required)
     * @param brandId Brand identifier (required)
     * @return Product with price in a date selected (status code 200)
     *         or Error in the request (status code 400)
     *         or Error in nthe server (status code 500)
     */
    @ApiOperation(value = "Get information about the price of a product in any enterprise of Inditex", nickname = "findPriceProductInSeason", notes = "Get information about the price of a product in any enterprise of Inditex in any date", response = PriceProductRDTO.class, authorizations = {
        
        @Authorization(value = "x-jwt-assertion")
         }, tags={ "prices", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Product with price in a date selected", response = PriceProductRDTO.class),
        @ApiResponse(code = 400, message = "Error in the request", response = ErrorResponseRDTO.class),
        @ApiResponse(code = 500, message = "Error in nthe server", response = ErrorResponseRDTO.class) })
    @GetMapping(
        value = "/prices",
        produces = { "application/json" }
    )
    default ResponseEntity<PriceProductRDTO> findPriceProductInSeason(@NotNull @ApiParam(value = "date for apply the rate of the product", required = true) @Valid @RequestParam(value = "appDate", required = true) @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME) OffsetDateTime appDate,@NotNull @ApiParam(value = "Product identifier", required = true) @Valid @RequestParam(value = "productId", required = true) Long productId,@NotNull @ApiParam(value = "Brand identifier", required = true) @Valid @RequestParam(value = "brandId", required = true) Long brandId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"brandName\" : \"brandName\", \"productId\" : \"\", \"rate\" : 0, \"endDate\" : \"2000-01-23T04:56:07.000+00:00\", \"price\" : 6.027456183070403, \"brandId\" : \"\", \"startDate\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}