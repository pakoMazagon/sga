package com.paradigma.sga.infrastructure.openAPI.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Payload error message
 */
@ApiModel(description = "Payload error message")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-03T12:11:46.146825400+02:00[Europe/Paris]")@lombok.Builder
									@lombok.NoArgsConstructor @lombok.AllArgsConstructor

public class ErrorResponseErrorRDTO   {
  @JsonProperty("message")
  private String message;

  @JsonProperty("code")
  private Integer code;

  public ErrorResponseErrorRDTO message(String message) {
    this.message = message;
    return this;
  }

  /**
   * error cause.
   * @return message
  */
  @ApiModelProperty(required = true, value = "error cause.")
  @NotNull


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ErrorResponseErrorRDTO code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * Response code of error
   * @return code
  */
  @ApiModelProperty(required = true, value = "Response code of error")
  @NotNull


  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorResponseErrorRDTO errorResponseError = (ErrorResponseErrorRDTO) o;
    return Objects.equals(this.message, errorResponseError.message) &&
        Objects.equals(this.code, errorResponseError.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponseErrorRDTO {\n");
    
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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

