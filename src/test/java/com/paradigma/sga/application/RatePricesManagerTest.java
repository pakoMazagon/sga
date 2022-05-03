package com.paradigma.sga.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.paradigma.sga.application.dto.BrandDTO;
import com.paradigma.sga.application.dto.PriceDTO;
import com.paradigma.sga.domain.entity.Brand;
import com.paradigma.sga.domain.entity.Price;
import com.paradigma.sga.domain.service.PricesService;

import lombok.val;

@ExtendWith(MockitoExtension.class)
public class RatePricesManagerTest {

	@Mock
	PricesService priceService;
	
	@InjectMocks
	private RatePriceManagerImpl ratePriceManager;
	
	@Test
    void shouldReturnPriceMajorPriority() {
        val price = Price.builder().id(1L).brand(Brand.builder().id(1L).description("ZARA").build()).startDate(LocalDateTime.parse("2020-06-14T00:00:00")).endDate(LocalDateTime.parse("2020-12-31T23:59:59")).priceList(1).productId(35455L).priority(0).price(35.50).curr("EUR").build();
        val price2 = Price.builder().id(2L).brand(Brand.builder().id(1L).description("ZARA").build()).startDate(LocalDateTime.parse("2020-06-14T15:00:00")).endDate(LocalDateTime.parse("2020-06-14T18:30:00")).priceList(2).productId(35455L).priority(1).price(25.45).curr("EUR").build();
        List<Price> listPrices = new ArrayList<>();
        listPrices.add(price);
        listPrices.add(price2);        
        when(priceService.findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfter(35455L, 1L, LocalDateTime.parse("2020-06-14T16:00:00"))).thenReturn(listPrices);
        
        Optional<PriceDTO> result = ratePriceManager.findRatePriceByProductBrandAndDate(35455L, 1L, LocalDateTime.parse("2020-06-14T16:00:00"));
        
        val priceDTO = PriceDTO.builder().id(2L).brand(BrandDTO.builder().id(1L).description("ZARA").build()).startDate(LocalDateTime.parse("2020-06-14T15:00:00")).endDate(LocalDateTime.parse("2020-06-14T18:30:00")).priceList(2).productId(35455L).priority(1).price(25.45).curr("EUR").build();
        assertNotNull(result);
        assertThat(priceDTO).isEqualToIgnoringGivenFields(priceDTO, "brand");
    }
	
	@Test
    void shouldReturnOptionalEmpty() {
                
        when(priceService.findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfter(35455L, 1L, LocalDateTime.parse("2022-06-14T16:00:00"))).thenReturn(new ArrayList<>());
        
        Optional<PriceDTO> result = ratePriceManager.findRatePriceByProductBrandAndDate(35455L, 1L, LocalDateTime.parse("2022-06-14T16:00:00"));
                
        assertEquals(result, Optional.empty());
    }
}
