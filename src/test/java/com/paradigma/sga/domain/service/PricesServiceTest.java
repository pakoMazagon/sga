package com.paradigma.sga.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import com.paradigma.sga.domain.entity.Brand;
import com.paradigma.sga.domain.entity.Price;
import com.paradigma.sga.domain.repository.PricesRepository;

import lombok.val;

@SpringBootTest
//@ActiveProfiles("test")
@EnableAutoConfiguration(exclude=LiquibaseAutoConfiguration.class)
public class PricesServiceTest{
	
	@Mock
	PricesRepository priceRepository;
	
	@InjectMocks
	private PricesServiceImpl priceService;
	
	@Value("${spring.application.name}")
	String name;
	
	
	@Test
    void shouldReturnOneElementGetAllPrices() {
        val price = mock(Price.class);
        List<Price> listPrices = new ArrayList<>();
        listPrices.add(price);
        when(priceRepository.findAll()).thenReturn(listPrices);
        
        List<Price> result = priceService.findAll();
        
        assertNotNull(result);
        assertEquals(result,listPrices);
        
    }
	
	@Test
    void shouldReturnPricesFilters() {
        val price = Price.builder().id(1L).brand(Brand.builder().id(1L).description("ZARA").build()).startDate(LocalDateTime.parse("2020-06-14T00:00:00")).endDate(LocalDateTime.parse("2020-12-31T23:59:59")).priceList(1).productId(35455L).priority(0).price(35.50).curr("EUR").build();
        val price2 = Price.builder().id(2L).brand(Brand.builder().id(1L).description("ZARA").build()).startDate(LocalDateTime.parse("2020-06-14T15:00:00")).endDate(LocalDateTime.parse("2020-06-14T18:30:00")).priceList(2).productId(35455L).priority(1).price(25.45).curr("EUR").build();
        List<Price> listPrices = new ArrayList<>();
        listPrices.add(price);
        listPrices.add(price2);        
        when(priceRepository.findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfter(35455L, 1L, LocalDateTime.parse("2020-06-14T16:00:00"))).thenReturn(listPrices);
        
        List<Price> result = priceService.findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfter(35455L, 1L, LocalDateTime.parse("2020-06-14T16:00:00"));
        
        assertNotNull(result);
        assertEquals(result.size(),listPrices.size());
        assertThat(result).isEqualTo(listPrices); 
        
    }
	
	@Test
    void shouldReturnEmpty() {
        when(priceRepository.findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfter(35455L, 1L, LocalDateTime.parse("2020-06-14T16:00:00"))).thenReturn(new ArrayList<>());
        
        List<Price> result = priceService.findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfter(35455L, 1L, LocalDateTime.parse("2020-06-14T16:00:00"));
        
        assertNotNull(result);
        assertEquals(result.size(),0);
        
    }
	
}
