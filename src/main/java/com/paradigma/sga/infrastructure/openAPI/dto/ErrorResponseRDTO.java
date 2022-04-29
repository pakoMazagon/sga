package com.paradigma.sga.infrastructure.openAPI.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.paradigma.sga.infrastructure.openAPI.dto.ErrorResponseErrorRDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Error in the API
 */
@ApiModel(description = "Error in the API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-04-29T12:22:08.005605900+02:00[Europe/Paris]")@lombok.Builder
									@lombok.NoArgsConstructor @lombok.AllArgsConstructor

public class ErrorResponseRDTO   {
  @JsonProperty("error")
  private ErrorResponseErrorRDTO error;

  public ErrorResponseRDTO error(ErrorResponseErrorRDTO error) {
    this.error = error;
    return this;
  }

  /**
   * Get error
   * @return error
  */
  @ApiModelProperty(value = "")

  @Valid

  public ErrorResponseErrorRDTO getError() {
    return error;
  }

  public void setError(ErrorResponseErrorRDTO error) {
    this.error = error;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorResponseRDTO errorResponse = (ErrorResponseRDTO) o;
    return Objects.equals(this.error, errorResponse.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponseRDTO {\n");
    
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

