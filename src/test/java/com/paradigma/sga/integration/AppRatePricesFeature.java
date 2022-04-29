package com.paradigma.sga.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.OffsetDateTime;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.paradigma.sga.application.RatePricesService;
import com.paradigma.sga.domain.repository.PricesRepository;
import com.paradigma.sga.domain.service.PricesService;
import com.paradigma.sga.infrastructure.openAPI.dto.PriceProductRDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppRatePricesFeature extends BaseTestcontainers {

	public static final String URL = "/prices?appDate=2020-06-14T18:00:01.000Z&productId=35455&brandId=1";

	@Autowired
	public TestRestTemplate testRestTemplate;

	@Autowired
	RatePricesService ratePricesService;

	@Autowired
	PricesService priceService;

	@Autowired
	PricesRepository priceRepository;

	@Test
	public void whenCallReturnTheRate() {
		ResponseEntity<PriceProductRDTO> result = testRestTemplate.getForEntity(URL, PriceProductRDTO.class);
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(result).isNotNull();
	}

	@ParameterizedTest
	@MethodSource("indTestParams")
	void indTest(int numTest, Long productId, Long brandId, OffsetDateTime dateOffset, Integer expected) throws Exception {
		// Given
		String url = "/prices?appDate=" + dateOffset + "&productId=" + productId + "&brandId=" + brandId;
		// when
		ResponseEntity<PriceProductRDTO> result = testRestTemplate.getForEntity(url, PriceProductRDTO.class);

		// then
		Assertions.assertEquals(expected, result.getBody().getRate());

		log.info(String.format("Test %s: petición a las %s:%s del día %s del producto %s para la brand %s (%s)", numTest, dateOffset.getHour(),
			dateOffset.getMinute(), dateOffset.getDayOfMonth(), productId, brandId, result.getBody().getBrandName()));
		log.info(String.format("...Dando como resultado la tarifa %s con un precio de %s",result.getBody().getRate(),result.getBody().getPrice()));
	}

	public static Stream<Arguments> indTestParams() {
		return Stream.of(Arguments.arguments(1, 35455L, 1L, "2020-06-14T10:00:00.000Z", 1), Arguments.arguments(2, 35455L, 1L, "2020-06-14T16:00:00.000Z", 2),
			Arguments.arguments(3, 35455L, 1L, "2020-06-14T21:00:01.000Z", 1), Arguments.arguments(4, 35455L, 1L, "2020-06-15T10:00:01.000Z", 3), Arguments
				.arguments(5, 35455L, 1L, "2020-06-16T21:00:01.000Z", 4));
	}

}
