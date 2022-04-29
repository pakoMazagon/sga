package com.paradigma.sga.infrastructure.openAPI.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PriceProductRDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-04-29T12:22:08.005605900+02:00[Europe/Paris]")@lombok.Builder
									@lombok.NoArgsConstructor @lombok.AllArgsConstructor

public class PriceProductRDTO   {
  @JsonProperty("productId")
  private Long productId = null;

  @JsonProperty("brandId")
  private Long brandId = null;

  @JsonProperty("brandName")
  private String brandName;

  @JsonProperty("rate")
  private Integer rate;

  @JsonProperty("startDate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startDate;

  @JsonProperty("endDate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime endDate;

  @JsonProperty("price")
  private Double price;

  public PriceProductRDTO productId(Long productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   * @return productId
  */
  @ApiModelProperty(value = "")


  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public PriceProductRDTO brandId(Long brandId) {
    this.brandId = brandId;
    return this;
  }

  /**
   * Get brandId
   * @return brandId
  */
  @ApiModelProperty(value = "")


  public Long getBrandId() {
    return brandId;
  }

  public void setBrandId(Long brandId) {
    this.brandId = brandId;
  }

  public PriceProductRDTO brandName(String brandName) {
    this.brandName = brandName;
    return this;
  }

  /**
   * Get brandName
   * @return brandName
  */
  @ApiModelProperty(value = "")


  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public PriceProductRDTO rate(Integer rate) {
    this.rate = rate;
    return this;
  }

  /**
   * Get rate
   * @return rate
  */
  @ApiModelProperty(value = "")


  public Integer getRate() {
    return rate;
  }

  public void setRate(Integer rate) {
    this.rate = rate;
  }

  public PriceProductRDTO startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Get startDate
   * @return startDate
  */
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public PriceProductRDTO endDate(OffsetDateTime endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Get endDate
   * @return endDate
  */
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(OffsetDateTime endDate) {
    this.endDate = endDate;
  }

  public PriceProductRDTO price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  @ApiModelProperty(value = "")


  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriceProductRDTO priceProduct = (PriceProductRDTO) o;
    return Objects.equals(this.productId, priceProduct.productId) &&
        Objects.equals(this.brandId, priceProduct.brandId) &&
        Objects.equals(this.brandName, priceProduct.brandName) &&
        Objects.equals(this.rate, priceProduct.rate) &&
        Objects.equals(this.startDate, priceProduct.startDate) &&
        Objects.equals(this.endDate, priceProduct.endDate) &&
        Objects.equals(this.price, priceProduct.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, brandId, brandName, rate, startDate, endDate, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriceProductRDTO {\n");
    
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    brandId: ").append(toIndentedString(brandId)).append("\n");
    sb.append("    brandName: ").append(toIndentedString(brandName)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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

