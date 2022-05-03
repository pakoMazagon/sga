package com.paradigma.sga.infrastructure;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.paradigma.sga.application.RatePricesManager;
import com.paradigma.sga.application.dto.BrandDTO;
import com.paradigma.sga.application.dto.PriceDTO;
import com.paradigma.sga.infrastructure.controller.PricesController;

@WebMvcTest(PricesController.class)
public class PricesControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private RatePricesManager ratePricesService;
    
    
    @Test
    void return_prices_products() throws Exception {
    	
    	Optional<PriceDTO> priceDTOOpt = Optional.of(PriceDTO.builder().id(2L).brand(BrandDTO.builder().id(1L).description("ZARA").build()).startDate(LocalDateTime.parse("2020-06-14T15:00:00")).endDate(LocalDateTime.parse("2020-06-14T18:30:00")).priceList(2).productId(35455L).priority(1).price(25.45).curr("EUR").build());

        when(ratePricesService.findRatePriceByProductBrandAndDate(35455L,1L,LocalDateTime.parse("2020-06-14T18:00:01"))).thenReturn(priceDTOOpt);

        
        this.mockMvc
                .perform(get("/prices?appDate=2020-06-14T18:00:01.000Z&productId=35455&brandId=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455L))
                .andExpect(jsonPath("$.brandId").value(1L))
        		.andExpect(jsonPath("$.rate").value(2))
        		.andExpect(jsonPath("$.price").value(25.45));
    }
}
