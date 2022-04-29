package com.paradigma.sga.domain.repository;



import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.paradigma.sga.domain.entity.Brand;
import com.paradigma.sga.domain.entity.Price;
import com.paradigma.sga.integration.BaseTestcontainers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceRepositoryTCTest extends BaseTestcontainers{
	
	@Autowired
	PricesRepository priceRepository;
	
		
	
	@Test
	void return_prices_by_productId_and_brandId_and_date() {
		Price price = Price.builder().id(1L).brand(Brand.builder().id(1L).description("ZARA").build()).startDate(LocalDateTime.parse("2020-06-14T00:00:00")).endDate(LocalDateTime.parse("2020-12-31T23:59:59")).priceList(1).productId(35455L).priority(0).price(35.5).curr("EUR").build();		
		LocalDateTime dateInd = LocalDateTime.parse("2020-06-15T11:25");
		List<Price> listPrices = priceRepository.findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfter(35455L,1L,dateInd);
		assertThat(listPrices).contains(price);
	}
	
}
